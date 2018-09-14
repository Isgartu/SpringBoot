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
import com.isgartu.model.Movement;
import com.isgartu.repository.MovementRepository;

@RestController
@RequestMapping( "movements" )
public class MovementController {

	@Autowired
	private MovementRepository movementRepository;
	
	@GetMapping({ "", "/"})
	public List<Movement> getAllMovements() {
		return movementRepository.findAll();
	}
	
	@GetMapping( "/{movementId}" )
	public Optional<Movement> getMovementById(
			@PathVariable Long movementId){
		if(movementId != null) {
			return movementRepository.findById(movementId);
		}
		else {
			throw new ResourceNotFoundException("Invalid Search or invalid SearchParam, only you can search by movementId, movementName, movementCentury, movementYear or movementArt");
		}
	}
	
	
	@GetMapping( "/search" )
	public List<Movement> getMovementBySearch(
			@RequestParam (value = "movementName",	  required = false) String 	 movementName,
			@RequestParam (value = "movementCentury", required = false) String 	 movementCentury,
			@RequestParam (value = "movementYear",	  required = false) String 	 movementYear,
			@RequestParam (value = "movementArt",	  required = false) Art movementArt) {
		
		if (!StringUtils.isEmpty(movementName)) {
			return movementRepository.findByName(movementName);
		} else if (!StringUtils.isEmpty(movementCentury)) {
			return movementRepository.findByCentury(movementCentury);
		} else if (!StringUtils.isEmpty(movementYear)) {
			return movementRepository.findByYear(movementYear);
		} else if (!StringUtils.isEmpty(movementArt)) {
			return movementRepository.findByArt(movementArt);
		}else {
			throw new ResourceNotFoundException("Invalid Search or invalid SearchParam, only you can search by movementId, movementName, movementCentury, movementYear or movementArt");
		}
	}
	
}

