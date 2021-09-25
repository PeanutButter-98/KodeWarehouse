package com.example.JPAEntities.student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.JPAEntities.subject.Subject;
import com.example.JPAEntities.teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@Entity
@Table(name = "student")
@ToString
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	/*
	 * public Student(int id, String name, String email) { super(); this.id = id;
	 * this.name = name; this.email = email; }
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "enrolledStudents")
	private Set<Subject> subject = new HashSet<>();


	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	public Set<Subject> getSubject() {
		return subject;
	}

	@JsonIgnore
	@ManyToMany(mappedBy="students")
	private List<Teacher> teacher;

	/*
	 * public Set<Teacher> getTeacher() { return teacher; }
	 * 
	 * @ManyToMany(mappedBy="students") private Set<Teacher> teacher= new
	 * HashSet<>();;
	 */
	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}