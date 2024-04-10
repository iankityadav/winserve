package com.easebean.winserve.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easebean.winserve.model.WServer;
import com.easebean.winserve.repository.WServerRepository;

@Service
public class WServerSpringService {
	
	@Autowired
	private WServerRepository wServerRepository;
	
	public List<WServer> getAll(){
		return wServerRepository.findAll();
	}
	
}
