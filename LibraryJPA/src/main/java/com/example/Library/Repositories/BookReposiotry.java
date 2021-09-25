package com.example.Library.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Library.Entities.Book;

@Repository
public interface BookReposiotry extends CrudRepository<Book,Long>
{
	
}