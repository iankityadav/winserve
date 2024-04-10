package com.easebean.winserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easebean.winserve.exception.ResourceNotFoundException;
import com.easebean.winserve.model.WService;
import com.easebean.winserve.repository.WServiceRepository;
import com.easebean.winserve.resource.CommandExecutor;

@Service
public class WServiceSpringService {

	@Autowired
	private WServiceRepository wServiceRepository;

	public WService startService(Long id) {
		WService wService = findService(id);
		CommandExecutor.execute("sc start "+wService.getName());
		return wService;
	}

	private WService findService(Long id) {
		WService wService = null;
		try {
			wService = wServiceRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Service with id " + id + " is not found"));
		} catch (ResourceNotFoundException e) {
			System.out.println(e);
		}
		return wService;
	}
}
