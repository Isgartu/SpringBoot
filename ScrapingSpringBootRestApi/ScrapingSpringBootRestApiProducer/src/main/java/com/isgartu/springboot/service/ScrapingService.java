package com.isgartu.springboot.service;

import java.util.List;

import com.isgartu.springboot.model.Web;

public interface ScrapingService {

	List<Web> getByUrl(String url);
}
