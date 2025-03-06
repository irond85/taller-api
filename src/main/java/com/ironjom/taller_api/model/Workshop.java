package com.ironjom.taller_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Workshops")
@Data
public class Workshop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idWorkshop;
	private String strName;
	private String strAddress;
	
	@OneToMany
	@JoinColumn(name = "idReview")
	private List<Review> reviews;
	
}
