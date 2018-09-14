package com.isgartu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name = "movements")
public class Movement {

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
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "art_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
//  Con estas anotaciones solo pinta el id de la clase art, las comento porque quiero que aparezca todo
//    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//    @JsonIdentityReference(alwaysAsId=true)
//    @JsonProperty("art_id")
	private Art art;
	
}
