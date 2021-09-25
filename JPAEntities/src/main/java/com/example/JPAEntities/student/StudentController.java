package com.example.JPAEntities.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	
	@Autowired
	private StudentRepository strepo;
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return strepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id)
	{
		return strepo.findById(id).orElse(null);
	}
	@PostMapping("/addstud")
	public Student addStudent(@RequestBody Student student)
	{
		return strepo.save(student);
	}
	

}
