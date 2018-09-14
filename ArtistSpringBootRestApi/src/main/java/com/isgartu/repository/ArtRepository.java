package com.isgartu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isgartu.model.Art;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long>{
	Optional<Art> findById(Long id);
	
	List<Art> findByName(String name);
	List<Art> findByCentury(String century);
	List<Art> findByYear(String year);
}
