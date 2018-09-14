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
import com.isgartu.model.Artist;
import com.isgartu.model.Movement;
import com.isgartu.repository.ArtistRepository;

@RestController
@RequestMapping( "artists" )
public class ArtistController {

	@Autowired
	private ArtistRepository artistRepository;
	
	@GetMapping({ "", "/" })
	public List<Artist> getAllArtists() {
		return artistRepository.findAll();
	}
	
	@GetMapping( "/{artistId}" )
	public Optional<Artist> getArtistById(
			@PathVariable Long artistId){
		if(artistId != null) {
			return artistRepository.findById(artistId);
		}
		else {
			throw new ResourceNotFoundException("Invalid Search or invalid SearchParam, only you can search by movementId, movementName, movementCentury, movementYear or movementArt");
		}
	}
	
	@GetMapping( "/search" )
	public List<Artist> getArtistBySearch(
			@RequestParam (value = "artistName",		required = false) String   artistName,
			@RequestParam (value = "artistSurnames",	required = false) String   artistSurnames,
			@RequestParam (value = "artistNickname",	required = false) String   artistNickname,
			@RequestParam (value = "artistNationality",	required = false) String   artistNationality,
			@RequestParam (value = "artistBorn",		required = false) String   artistBorn,
			@RequestParam (value = "artistDied",		required = false) String   artistDied,
			@RequestParam (value = "artistArt",			required = false) Art 	   artistArt,
			@RequestParam (value = "artistMovement",	required = false) Movement artistMovement) {
		
		if (!StringUtils.isEmpty(artistName)){
			return artistRepository.findByName(artistName);
		} else if (!StringUtils.isEmpty(artistSurnames)){
			return artistRepository.findBySurnames(artistSurnames);
		} else if (!StringUtils.isEmpty(artistNickname)){
			return artistRepository.findByNickname(artistNickname);
		} else if (!StringUtils.isEmpty(artistNationality)){
			return artistRepository.findByNationality(artistNationality);
		} else if (!StringUtils.isEmpty(artistBorn)){
			return artistRepository.findByBorn(artistBorn);
		} else if (!StringUtils.isEmpty(artistDied)){
			return artistRepository.findByDied(artistDied);
		} else if (!StringUtils.isEmpty(artistArt)){
			return artistRepository.findByArt(artistArt);
		} else if (!StringUtils.isEmpty(artistMovement)) {
			return artistRepository.findByMovement(artistMovement);
		} else {
			throw new ResourceNotFoundException("Invalid Search or invalid SearchParam, only you can search by artistId, artistName, artistSurnames, artistNickname, artistNationality, artistBorn, artistDied, artistArt or artistMovement");
		}
	}
	
}
