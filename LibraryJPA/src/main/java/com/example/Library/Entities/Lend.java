package com.example.Library.Entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "lend")
public class Lend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;
	private Instant startOn;
	private Instant dueOn;
	@Enumerated(EnumType.ORDINAL)
	private LendStatus lstatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getStartOn() {
		return startOn;
	}

	public void setStartOn(Instant startOn) {
		this.startOn = startOn;
	}

	public Instant getDueOn() {
		return dueOn;
	}

	public void setDueOn(Instant dueOn) {
		this.dueOn = dueOn;
	}

	public LendStatus getLstatus() {
		return lstatus;
	}

	public void setLstatus(LendStatus lstatus) {
		this.lstatus = lstatus;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Lend(Long id, String status, Instant startOn, Instant dueOn, LendStatus lstatus, Book book, Member member) {
		super();
		this.id = id;
		this.status = status;
		this.startOn = startOn;
		this.dueOn = dueOn;
		this.lstatus = lstatus;
		this.book = book;
		this.member = member;
	}

	// Many to one bw book and lend
	@ManyToOne
	@JoinColumn(name = "book_id")
	@JsonManagedReference
	private Book book;

	// M to One bw member n lend
	@ManyToOne
	@JoinColumn(name = "member_id")
	@JsonManagedReference
	private Member member;
}
