package com.isgartu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isgartu.model.Art;
import com.isgartu.model.Artist;
import com.isgartu.model.Movement;

public interface ArtistRepository extends JpaRepository<Artist, Long>{
	Optional<Artist> findById(Long id);
	
	List<Artist> findByName(String name);
	List<Artist> findBySurnames(String surnames);
	List<Artist> findByNickname(String nickname);
	List<Artist> findByNationality(String nationality);
	List<Artist> findByBorn(String born);
	List<Artist> findByDied(String died);
	
	List<Artist> findByArt(Art art);
	List<Artist> findByMovement(Movement movement);
}
