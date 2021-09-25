package com.example.CRUDJHM.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDJHM.Entity.Segments;
import com.example.CRUDJHM.Service.SegmentsService;

@RestController
@RequestMapping("/products/api/segments")
public class SegmentsController
{
	@Autowired
	private SegmentsService segservices;
	public SegmentsController(SegmentsService segservices)
	{
		this.segservices=segservices;
	}
	
	@PostMapping("/saveSeg")
	public Segments addProduct(@RequestBody Segments segments)
	{
		return segservices.saveProduct(segments);
	}
	
	@PostMapping("/saveAllSeg")
	public List<Segments> addProducts(@RequestBody List<Segments> seglist)
	{
		return segservices.saveProduct(seglist);
	}
	
	@GetMapping("/allSeg")
	public List<Segments> getAll()
	{
		return segservices.getProducts();
	}
	
	@GetMapping("/{id}")
	public Segments findProductById(@PathVariable("id") int id)
	{
		return segservices.getoneProduct(id);
	}
	@GetMapping()
	public Segments findProductsByName(@RequestParam(value="name") String name)
	{
		return segservices.getoneSegmentByName(name);
	}
	
	@PutMapping("/updateSeg/{id}")
	public Segments updateProduct(@RequestBody Segments segs, @PathVariable("id") int id)
	{
		return segservices.updateProduct(segs, id);
	}
	
	@DeleteMapping("/removeSeg/{id}")
	public String removeProduct(@PathVariable("id") int id)
	{
		return segservices.deleteProduct(id);
	}
	
} 