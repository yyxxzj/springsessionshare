package com.npf.dao;

import java.util.List;

import com.npf.model.Student;

public interface StudentDao {

	public void save(Student student);
	
	public Student find(String id);
	
	public void delete(String id);
	
	public void update(Student student);
	
	public List<Student> findAll();
}
