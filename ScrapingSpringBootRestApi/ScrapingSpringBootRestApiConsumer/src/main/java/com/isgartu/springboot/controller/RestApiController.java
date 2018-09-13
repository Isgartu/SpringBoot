package com.isgartu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.isgartu.springboot.service.ScrapingServiceImpl;

@Controller
public class RestApiController {

	//define a service constant
    private final ScrapingServiceImpl service;

    //Argument contructor of controller, pass in the service
    //and Autowire it
    @Autowired
    public RestApiController(ScrapingServiceImpl service){
       this.service = service;
    }
    
    @GetMapping("/")
    public String init(){
        return "home";
    }
	
   
    @GetMapping("/programacion")
    public String getProgramacion(Model model){
        model.addAttribute("webs", service.findProgramacion());
        return "webs";
    }
    
    @GetMapping("/seguridad")
    public String getSeguridad(Model model){
        model.addAttribute("webs", service.findSeguridad());
        return "webs";
    }

}