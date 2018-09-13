package com.isgartu.springboot;
 
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;
 

public class SpringBootRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/api";
     
    
    /* GET */
    @SuppressWarnings("unchecked")
    private static void getByUrl(){
        System.out.println("Testing getByUrl API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> webMap = restTemplate.getForObject(REST_SERVICE_URI+"/scraping/?url=https://www.softzone.es/category/programacion/", List.class);
         
        if(webMap!=null){
            for(LinkedHashMap<String, Object> web : webMap){
                System.out.println("*************\n title="+web.get("title")+",\n description="+web.get("description")+",\n link="+web.get("link")+",\n date="+web.get("date"));;
            }
        }else{
            System.out.println("No web exist----------");
        }
    }
 
    public static void main(String args[]){
    	getByUrl();
    }
}