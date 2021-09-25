package com.example.CRUDJHM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CRUDJHM.Entity.Product;

@Repository
public interface Repos extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
