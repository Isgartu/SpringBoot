package com.isgartu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isgartu.model.Art;
import com.isgartu.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{
	Optional<Movement> findById(Long id);
	
	List<Movement> findByName(String name);
	List<Movement> findByCentury(String century);
	List<Movement> findByYear(String year);
	
	List<Movement> findByArt(Art art);
}
