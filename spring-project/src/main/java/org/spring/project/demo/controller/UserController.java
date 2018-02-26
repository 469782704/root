package org.spring.project.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.spring.project.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class UserController {

	private ModelMap sendMesage(ModelMap map, String name, Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		List list = new ArrayList();
		list.add(user);
		map.addAttribute("user", list);
		return map;
	}

	/*
	 * 直接返回页面
	 */
	@RequestMapping("/demoString")
	public String demoString() {
		return "demoString";
	}

	/*
	 * ModelMap形式返回页面并带参
	 */
	@RequestMapping("/demoModelAndView")
	public ModelAndView demoModelAndView() {
		User user = new User();
		user.setName("旺旺写的demoModelAndView");
		user.setAge(26);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("demoModelAndView");
		mv.addObject("user", user);
		return mv;
	}

	/*
	 * String形式返回页面并带参
	 */
	@RequestMapping("/demoModelMap")
	public String demoModelMap(ModelMap map) {
		map = sendMesage(map,"旺旺写的demoModelMap",26);
		return "demoModelMap";
	}

	/*
	 * 重定向
	 */
	@RequestMapping("/demoRedirect")
	public String demoRedirect(ModelMap map, HttpServletRequest request) {
		return "redirect:/test/demoString";
	}

	/*
	 * get请求
	 */
	@RequestMapping("/demoGet/{id}/{name}")
	public String demoGet(ModelMap map, @PathVariable("id") Integer sid, @PathVariable("name") String sname) {
		System.out.println(sid);
		System.out.println(sname);
		map = sendMesage(map,sname,sid);
		return "demoModelMap";
	}

	/*
	 * post请求 使用HttpServletRequest
	 */
	@RequestMapping("/demoPost")
	public String demoPost(ModelMap map, HttpServletRequest request) {
		String name = (String) request.getParameter("sname");
		Integer id = Integer.parseInt(request.getParameter("sid"));
		map = sendMesage(map,name,id);
		return "demoModelMap";
	}
	/*
	 * post请求使用user对象
	 */
	@RequestMapping("/demoPostUser")
	public String demoPost(ModelMap map,User user){
		map = sendMesage(map,user.getName(),user.getAge());
		return "demoModelMap";
	}
	/*
	 * 得到json串
	 */
	@RequestMapping("/demoJson")
	@ResponseBody
	public User demoJson(){
		User  user = new User();
		user.setName("json串");
		user.setAge(22);
		return user;
	}
	
	/*
	 * 前端传入json
	 */
	@RequestMapping("/demoJsonTo")
	public String demoJsonTo(@RequestBody User user){
		User user1 = user;
		System.out.println(user1.toString());
		return "demoModelMap";
	}
	/*
	 * 拦截器
	 */
	@RequestMapping("/demoInterceptor")
	public String demoInrterceptor(){
		return "demoString";
	}
	/*
	 * 文件上传
	 */
	@RequestMapping("/demoUpload")
	public String demoUpload(MultipartFile file,HttpServletRequest request){
		String name = file.getOriginalFilename();
		System.out.println("上传的文件是:"+name);
		File f = new File("/"+name);
		try {
			file.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "demoString";
	}
}
