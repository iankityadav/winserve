package com.easebean.winserve.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class WServer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private String userName;
	private String password;
	@OneToMany(mappedBy = "wServer")
	private Set<WService> services;
}
