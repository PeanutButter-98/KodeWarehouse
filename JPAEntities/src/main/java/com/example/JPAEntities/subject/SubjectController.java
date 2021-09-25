package com.example.JPAEntities.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAEntities.student.Student;
import com.example.JPAEntities.student.StudentRepository;
import com.example.JPAEntities.teacher.Teacher;
import com.example.JPAEntities.teacher.TeacherRepository;


@RestController
@RequestMapping("/subject")
public class SubjectController 
{
	
	@Autowired
	private SubjectRepository subrepo;
	
	@Autowired
	private TeacherRepository techr;
	
	
	@Autowired
	private StudentRepository strepo;
	
	@GetMapping
	public List<Subject> getAllSubjects()
	{
		return subrepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Subject getSubject(@PathVariable Long id)
	{
		return subrepo.findById(id).orElse(null);
	}
	@PostMapping("/addsub")
	public Subject addSubject(@RequestBody Subject subject)
	{
		return subrepo.save(subject);
	}
	
	
	//Assigning Students to Subjects
	@PutMapping("/{subjectId}/students/{studentId}")
	public Subject enrollStudentstoSubjects(@PathVariable Long subjectId, 
			@PathVariable Long studentId)
	{
		Subject subject = subrepo.findById(subjectId).get();
		Student student = strepo.findById(studentId).get();
		subject.enrollStudent(student);
		return subrepo.save(subject);
		
	}
	
	@GetMapping("/All")
	public List<Subject> getAllStudents()
	{
		return subrepo.findAll();
	}
	
	//Assigning Subject to a Teacher
	@PutMapping("/{subjectId}/teacher/{teacherId}")
	public Subject assignTeacher(@PathVariable Long subjectId, @PathVariable Long teacherId) {
		Subject sub = subrepo.findById(subjectId).get();
		Teacher teach = techr.findById(teacherId).get();
		sub.enrollTeacher(teach);
		return subrepo.save(sub);
	}
	 
}
