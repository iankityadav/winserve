package com.easebean.winserve.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.easebean.winserve.model.WServer;
import com.easebean.winserve.model.WService;
import com.easebean.winserve.service.WServerSpringService;
import com.easebean.winserve.service.WServiceSpringService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private WServerSpringService wServerSpringService;
	
	@Autowired
	private WServiceSpringService wServiceSpringService;

	@GetMapping("/all-servers")
	public List<WServer> getServers() {
		return wServerSpringService.getAll();
	}
	
	@GetMapping("/start-service/{id}")
	public WService startService(@PathVariable("id") Long id) {
		return wServiceSpringService.startService(id);
	}
}
