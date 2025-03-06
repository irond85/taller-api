package com.ironjom.taller_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Reviews")
@Data
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idReview;
	
	@ManyToOne
	@JoinColumn(name = "id_mechanic_r")
	private Mechanic mechanic;
	
	private String strDescription;
	private String strRating;

}
