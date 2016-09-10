package com.npf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npf.dao.StudentDao;
import com.npf.model.Student;
import com.npf.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public void save(Student student) {
		studentDao.save(student);		
	}

	public Student find(String id) {
		return studentDao.find(id);
	}

	public void delete(String id) {
		studentDao.delete(id);
	}

	public void update(Student student) {
		studentDao.update(student);
	}

	public List<Student> findAll() {
		return studentDao.findAll();
	}

}
