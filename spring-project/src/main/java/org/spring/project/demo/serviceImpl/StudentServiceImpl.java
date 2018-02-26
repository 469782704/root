package org.spring.project.demo.serviceImpl;

import org.spring.project.demo.bean.Student;
import org.spring.project.demo.dao.StudentMapper;
import org.spring.project.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	@Transactional
	public int createStudent(Student student,Student student1) {
		int s1=studentMapper.insertSelective(student);
		int s2=studentMapper.insertSelective(student1);
		return s1+s2;
	}

	
}
