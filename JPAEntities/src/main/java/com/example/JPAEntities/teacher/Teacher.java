package com.example.JPAEntities.teacher;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.JPAEntities.student.Student;
import com.example.JPAEntities.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@Entity
@Table(name = "teacher")
@ToString
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String specialization;

	/*
	 * @OneToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(name="teacher_wd_subject", joinColumns = {
	 * 
	 * @JoinColumn(name="teacher_id", referencedColumnName="id")},
	 * inverseJoinColumns = {@JoinColumn(name="subject_id",
	 * referencedColumnName="id")}) private Subject subject ;
	 */

	/*
	 * One to One between TEacher and subject
	 * 
	 * @OneToOne(mappedBy="teacherlisted") private Subject subject;
	 */

	@JsonIgnore
	@OneToMany(mappedBy = "teachers")
	private Set<Subject> subjects = new HashSet<>();

	public Set<Subject> getSubjects() {
		return subjects;
	}

	@ManyToMany
	@JsonIgnore
	private Set<Student> students = new HashSet<>();

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable(name="teacher_wd_students", joinColumns = {
	 * 
	 * @JoinColumn(name="teacher_id", referencedColumnName="id")},
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name="student_id", referencedColumnName="id") }) private
	 * Set<Student> students = new HashSet<>(); public void setStudents(Set<Student>
	 * students) { this.students = students; } public Set<Student> getStudents() {
	 * return students; }
	 */

	public String getSpecialization() {
		return specialization;
	}

	public Set<Student> getStudent() {
		return students;
	}

	public void setStudent(Set<Student> students) {
		this.students= students;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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

	/*
	 * public void enrollStudent(Student stud) { // TODO Auto-generated method stub
	 * students.add(stud); }
	 */
	public void enrollSubject(Subject sub) {
		// TODO Auto-generated method stub
		subjects.add(sub);
	}

	public void addStudents(Student stud) {
		students.add(stud);
	}
}