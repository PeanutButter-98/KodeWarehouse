package com.example.JPAEntities.teacher;

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

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private TeacherRepository teachepo;

	@Autowired
	private StudentRepository studentrepo;

	@GetMapping
	public List<Teacher> getAllStudents() {
		return teachepo.findAll();
	}

	@GetMapping("/{id}")
	public Teacher getStudent(@PathVariable Long id) {
		return teachepo.findById(id).orElse(null);
	}

	@PostMapping("/addteacher")
	public Teacher addStudent(@RequestBody Teacher teacher) {
		return teachepo.save(teacher);
	}

	// Assigning Teacher to Students
	@PutMapping("{teacherId}/student/{studentId}")
	public Teacher assignTeacher(@PathVariable Long teacherId, @PathVariable Long studentId) {
		Teacher teach = teachepo.findById(teacherId).get();
		Student stud = studentrepo.findById(studentId).get();
		teach.addStudents(stud);
		return teachepo.save(teach);
	}

}
