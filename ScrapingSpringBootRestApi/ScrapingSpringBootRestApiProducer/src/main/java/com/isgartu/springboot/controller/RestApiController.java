package com.isgartu.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isgartu.springboot.model.Web;
import com.isgartu.springboot.service.ScrapingService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
	
	@Autowired
	ScrapingService scrapingService;
	
	@RequestMapping(value = "/scraping/", method = RequestMethod.GET)
	public ResponseEntity<List<Web>> getByUrl( @RequestParam(value="url", required=true) String url) {
		List<Web> web = scrapingService.getByUrl(url);
		if (web.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Web>>(web, HttpStatus.OK);
	}

}