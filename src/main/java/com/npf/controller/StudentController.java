package com.npf.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.npf.model.Student;
import com.npf.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student/save")
	public String saveStudent(Student student){
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		student.setId(id);
		studentService.save(student);
		return "redirect:/student/find/all";
	}
	
	@RequestMapping("/student/update")
	public String updateStudent(Student student){
		studentService.update(student);
		return "redirect:/student/find/all";
	}
	
	@RequestMapping("/student/to/save/form")
	public String toSaveStudentForm(HttpSession session,HttpServletRequest request) throws UnknownHostException{
		String hostname = InetAddress.getLocalHost().getHostName();
		request.setAttribute("hostname", hostname);
		return "save";
	}
	
	@RequestMapping("/student/delete")
	public String deleteStudent(@RequestParam("id") String id){
		studentService.delete(id);
		return "redirect:/student/find/all";
	}
	
	@RequestMapping("/student/to/update/form")
	public String toUpdateStudentForm(@RequestParam("id") String id,Model model){
		Student stu = studentService.find(id);
		model.addAttribute("stu", stu);
		return "update";
	}
	
	@RequestMapping("/student/find/all")
	public String findStudents(Model model,HttpSession session,HttpServletRequest request) throws UnknownHostException{
		List<Student> stuList = studentService.findAll();
		model.addAttribute("stuList", stuList);
		String hostname = InetAddress.getLocalHost().getHostName();
		request.setAttribute("hostname", hostname);
		return "list";
	}
}
