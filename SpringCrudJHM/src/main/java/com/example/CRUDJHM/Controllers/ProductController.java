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

import com.example.CRUDJHM.Entity.Product;
import com.example.CRUDJHM.Entity.Segments;
import com.example.CRUDJHM.Repository.Repos;
import com.example.CRUDJHM.Repository.SegmentRepos;
import com.example.CRUDJHM.Service.ProductServices;

@RestController
@RequestMapping("/products/api")
public class ProductController
{
	
	
	@Autowired
	private Repos prodrepo;
	
	@Autowired
	private SegmentRepos segrepo;
	
	@Autowired
	private ProductServices productservices;
	public ProductController(ProductServices productservices)
	{
		this.productservices=productservices;
	}
	
	@PostMapping("/save")
	public Product addProduct(@RequestBody Product product)
	{
		return productservices.saveProduct(product);
	}
	
	@PostMapping("/saveAll")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return productservices.saveProduct(products);
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAll()
	{
		return productservices.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable("id") int id)
	{
		
		return productservices.getoneProduct(id);
	}
	@GetMapping()
	public Product findProductsByName(@RequestParam(value="name") String name)
	{
		return productservices.getoneProductByName(name);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id)
	{
		return productservices.updateProduct(product, id);
	}
	
	@DeleteMapping("/remove/{id}")
	public String removeProduct(@PathVariable("id") int id)
	{
		Product prd = findProductById(id);
		if(prd==null)
		{
			return "Product could not found";
		}
		return productservices.deleteProduct(id);
	}
	
	@PutMapping("/{productId}/segment/{segmentId}")
	public Product getSegmentOfConsequentSegment(@PathVariable int productId, @PathVariable int segmentId)
	{
		Product product = prodrepo.findById(productId).orElse(null);
		Segments seg = segrepo.findById(segmentId).orElse(null);
		product.addSegment(seg);
		return prodrepo.save(product);
		
	}
	
	
	
} 