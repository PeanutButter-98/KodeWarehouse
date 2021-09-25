package com.example.CRUDJHM.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDJHM.Entity.Product;
import com.example.CRUDJHM.Repository.Repos;

@Service
public class ProductServices 
{
	@Autowired
	private Repos repos;
	
	public ProductServices(Repos repos)
	{
		this.repos = repos;
	}
	
	//Save Single Product
	public Product saveProduct(Product product)
	{
		return repos.save(product);
	}
	//Save All Products
	public List<Product> saveProduct(List<Product> product)
	{
		return repos.saveAll(product);
	}
	
	//Get All Products
	public List<Product> getProducts()
	{
		return repos.findAll();
	}
	
	//Get Single Product by Id
	public Product getoneProduct(int id)
	{
		return repos.findById(id).orElse(null);
	}
	//Get a Product by Name
	public Product getoneProductByName(String name)
	{
		return repos.findByName(name);
	}
	
	//Delete By Id
	public String deleteProduct(int id)
	{
		repos.deleteById(id);
		return "Successfully Deleted";
	}
	
	//Update Product By id
	
	public Product updateProduct(Product product, int id)
	{
		Product availabelproduct = repos.findById(id).orElse(null);
		availabelproduct.setName(product.getName());
		availabelproduct.setPrice(product.getPrice());
		availabelproduct.setQuantity(product.getQuantity());
		return repos.save(availabelproduct);
	}
	
}