package com.isgartu.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name = "artists")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 120)
	private String name;
	
	@Size(max = 240)
	private String surnames;
	
	private String nickname;
	
	private String nationality;
	
	private String born;
	
	private String died;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "art_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Art art;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "movement_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Movement movement;
	
}
