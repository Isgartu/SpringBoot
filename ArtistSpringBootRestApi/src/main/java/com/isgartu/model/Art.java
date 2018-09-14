package com.isgartu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
@Entity
@Table(name = "arts")
public class Art {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 120)
	private String name;
	
	@Size(max = 120)
	private String century;
	
	@Size(max = 120)
	private String year;
	
	@Lob
	private String summary;

}
