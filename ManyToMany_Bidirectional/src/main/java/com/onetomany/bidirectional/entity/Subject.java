package com.onetomany.bidirectional.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "student_enrolled",
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	public Set<Student> enrolledStudents = new HashSet<Student>();

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	

	
}
