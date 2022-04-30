package com.onetomany.bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.bidirectional.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
