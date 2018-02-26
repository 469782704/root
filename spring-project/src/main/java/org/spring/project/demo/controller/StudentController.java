package org.spring.project.demo.controller;

import org.spring.project.demo.bean.Student;
import org.spring.project.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/show")
	public String show(){
		Student student =  new Student();
		student.setId(3);
		student.setName("wa旺旺");
		student.setAge(15);
		Student student1 =  new Student();
		student1.setId(1);
		student1.setName("旺旺");
		student1.setAge(15);
		int result = studentService.createStudent(student,student1);
		System.out.println("插入结果:"+result);
		return "demoString";
	}
	
	
}
