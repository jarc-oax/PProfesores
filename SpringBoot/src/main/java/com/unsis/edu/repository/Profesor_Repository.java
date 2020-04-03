package com.unsis.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unsis.edu.model.Profesor;

@Repository
public interface Profesor_Repository extends JpaRepository<Profesor, Long>{

}
