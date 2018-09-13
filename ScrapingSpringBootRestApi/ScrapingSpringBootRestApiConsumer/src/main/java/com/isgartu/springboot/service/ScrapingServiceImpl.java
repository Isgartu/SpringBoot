package com.isgartu.springboot.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.isgartu.springboot.model.Web;

@Service
public class ScrapingServiceImpl implements ScrapingService {

	//define a RestTemplate object
    private final RestTemplate restTemplate;
	
	//web service resources endpoints
//    private final String GET_ALL_URL = "http://localhost:8080/SpringBootRestApi/api/scraping/?url=https://www.softzone.es/category/programacion/";
	
    @Value("${resources.url.programacion}")
    private String programacion;
    
    @Value("${resources.url.seguridad}")
    private String seguridad;
    
    //define an argument constructor, pass in the RestTemplate object
    //and Autowire it
    @Autowired
    public ScrapingServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
	public List<Web> findProgramacion(){
        return Arrays.stream(restTemplate.getForObject(programacion, Web[].class)).collect(Collectors.toList());
    }
	
	public List<Web> findSeguridad(){
        return Arrays.stream(restTemplate.getForObject(seguridad, Web[].class)).collect(Collectors.toList());
    }
}
