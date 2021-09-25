package com.example.Library.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Library.Entities.Lend;

@Repository
public interface LendRepository extends CrudRepository<Lend, Long>
{

}
