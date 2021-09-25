package com.example.JPAEntities.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JPAEntities.teacher.Teacher;
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>{

	

}
