package com.example.Library.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Library.Entities.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>
{

}
