package com.easebean.winserve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.AccessLevel;

@Entity
@Data
public class WService {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	@Getter(AccessLevel.NONE)
	@ManyToOne
	@JoinColumn(name="server_id")
	private WServer wServer;
}
