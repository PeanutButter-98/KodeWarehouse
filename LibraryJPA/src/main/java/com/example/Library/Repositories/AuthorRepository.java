package com.example.Library.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Library.Entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Integer>{

}
