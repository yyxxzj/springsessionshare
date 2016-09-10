package com.npf.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.npf.dao.StudentDao;
import com.npf.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private RedisTemplate<String,Student> redisTemplate;
	
	@Resource(name="redisTemplate")
	private HashOperations<String,String,Student> opsForHash;
	
	public static final String STUDENT = "student";
	
	public void save(Student student) {
		opsForHash.put(STUDENT, student.getId(), student);
	}

	public Student find(String id) {
		Student student = opsForHash.get(STUDENT, id);
		return student;
	}

	public void delete(String id) {
		opsForHash.delete(STUDENT, id);
	}

	public void update(Student student) {
		opsForHash.put(STUDENT, student.getId(), student);
	}

	public List<Student> findAll() {
		Map<String, Student> entries = opsForHash.entries(STUDENT);
		List<Student> stuList = new ArrayList<Student>();
		for(Entry<String, Student> entry : entries.entrySet()){
			stuList.add(entry.getValue());
		}
		return stuList;
	}
}
