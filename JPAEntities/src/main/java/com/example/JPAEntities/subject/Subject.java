package com.example.JPAEntities.subject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.JPAEntities.student.Student;
import com.example.JPAEntities.teacher.Teacher;

import lombok.ToString;

@Entity
@Table(name = "subject")
@ToString
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToMany
	@JoinTable(name = "student_enrolled", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private Set<Student> enrolledStudents = new HashSet<>();
	/*
	 * @OneToOne(mappedBy = "subject") private Teacher teacher; public Teacher
	 * getTeacher() { return teacher; } public void setTeacher(Teacher teacher) {
	 * this.teacher = teacher; }
	 */

	/*
	 * One to One Bw Teachers and Subject
	 * 
	 * @OneToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(name="teacher_wd_subject", joinColumns = {
	 * 
	 * @JoinColumn(name="subject_id", referencedColumnName="id")},
	 * inverseJoinColumns = {@JoinColumn(name="teacher_id",
	 * referencedColumnName="id")}) private Teacher teacherlisted; public Teacher
	 * getTeacherlisted() { return teacherlisted; }
	 */

	/*
	 * public void setTeacherlisted(Teacher teacherlisted) { this.teacherlisted =
	 * teacherlisted; }
	 */

	// One to Many
	// Teacher teaches many subject but subject has only one teacher

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	private Teacher teachers;

	public Teacher getTeacherlisted() {
		return teachers;
	}

	public void setTeacherlisted(Teacher teachers) {
		this.teachers = teachers;
	}

	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
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

	public void enrollStudent(Student student) {
		enrolledStudents.add(student);
	}

	public void enrollTeacher(Teacher teach) { // TODO Auto-generated method stub
		setTeacherlisted(teach);
		teachers.setName(teach.getName());
		teachers.setSpecialization(teach.getSpecialization());
	}

}