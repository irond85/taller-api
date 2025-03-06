package com.ironjom.taller_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Mechanics")
@Data
public class Mechanic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMechanic;
	private String strName;
	private String strDocument;
	private String strPhone;
	private String strEmail;

	@OneToMany(mappedBy = "mechanic")
	private List<Review> reviews;

	@OneToMany(mappedBy = "mechanic")
	private List<Booking> bookings;

}
