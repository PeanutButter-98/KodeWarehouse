package com.example.CRUDJHM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDJHM.Entity.Segments;

@Repository
public interface SegmentRepos extends JpaRepository<Segments,Integer> {

	Segments findByProducttype(String name);
}
