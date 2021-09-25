package com.example.CRUDJHM.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*@Getter
@Setter*/

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@ToString
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String quantity;
	private double price;
	
	
	@ManyToMany
	@JoinTable(name="product_wd_segment", joinColumns = {
			@JoinColumn(name="prod_id", referencedColumnName="id")},
			inverseJoinColumns = {
					@JoinColumn(name="segment_id", referencedColumnName="id")
		})
	private Set<Segments> segment = new HashSet<>();
	
	
	/*
	 * public Segments getSegment() { return segment; } public void
	 * setSegment(Segments segment) { this.segment = segment; }
	 */
	 
	public int getId() {
		return id;
	}

	public void setSegment(Set<Segments> segment) {
		this.segment = segment;
	}

	public Set<Segments> getSegment() {
		return segment;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public void addSegment(Segments seg) {
		// TODO Auto-generated method stub
		
		/*
		 * setSegment(seg); segment.setAmount(seg.getAmount());
		 * segment.setModel(seg.getModel());
		 * segment.setProducttype(seg.getProducttype()); segment.setId(seg.getId());
		 * 
		 */
		segment.add(seg);
		System.out.println(segment);
	}
}