package com.example.CRUDJHM.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDJHM.Entity.Segments;
import com.example.CRUDJHM.Repository.SegmentRepos;

@Service
public class SegmentsService 
{
	@Autowired
	private SegmentRepos segrepos;
	 public SegmentsService(SegmentRepos segments) { this.segrepos = segments; }
	 
	//Save Single Product
	public Segments saveProduct(Segments segs)
	{
		return segrepos.save(segs);
	}
	//Save All Products
	public List<Segments> saveProduct(List<Segments> segs)
	{
		return segrepos.saveAll(segs);
	}
	
	//Get All Products
	public List<Segments> getProducts()
	{
		return segrepos.findAll();
	}
	
	//Get Single Product by Id
	public Segments getoneProduct(int id)
	{
		return segrepos.findById(id).orElse(null);
	}
	//Get a Product by Name
	public Segments getoneSegmentByName(String name)
	{
		return segrepos.findByProducttype(name);
	}
	
	//Delete By Id
	public String deleteProduct(int id)
	{
		segrepos.deleteById(id);
		return "Successfully Deleted";
	}
	
	//Update Product By id
	
	public Segments updateProduct(Segments segments, int id)
	{
		Segments availabelseg = segrepos.findById(id).orElse(null);
		return segrepos.save(availabelseg);
	}

}
