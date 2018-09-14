package com.isgartu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isgartu.exception.ResourceNotFoundException;
import com.isgartu.model.Art;
import com.isgartu.repository.ArtRepository;

@RestController
@RequestMapping( "/arts" )
public class ArtController {

	@Autowired
	ArtRepository artRepository;
	
	@GetMapping({ "", "/" })
	public List<Art> getAllArts() {
		return artRepository.findAll();
	}
	
	@GetMapping("/{artId}")
	public Optional<Art> getArtById(
			@PathVariable Long artId) {
		if(artId != null) {
			return artRepository.findById(artId);
		}
		else {
			throw new ResourceNotFoundException("Invalid Search or invalid SearchParam, only you can search by movementId, movementName, movementCentury, movementYear or movementArt");
		}
	}
	
	@GetMapping( "/search" )
	public List<Art> getArtBySearch(
			@RequestParam (value = "artName",	required = false) String artName,
			@RequestParam (value = "artCentury",required = false) String artCentury,
			@RequestParam (value = "artYear",	required = false) String artYear) {
		
		if (!StringUtils.isEmpty(artName)){
			return artRepository.findByName(artName);
		} else if (!StringUtils.isEmpty(artCentury)){
			return artRepository.findByCentury(artCentury);
		} else if (!StringUtils.isEmpty(artYear)){
			return artRepository.findByYear(artYear);
		} else {
			throw new ResourceNotFoundException("Invalid Search or invalid SearchParam, only you can search by artId, artName, artCentury or artYear");
		}
	}
}
