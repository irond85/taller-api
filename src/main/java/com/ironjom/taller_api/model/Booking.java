package com.ironjom.taller_api.model;

import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idVehicle;

	@ManyToOne
	@JoinColumn(name = "id_customer_b")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "id_vehicle_b")
	private Vehicle vehicle;

	@ManyToOne
	@JoinColumn(name = "id_mechanic_b")
	private Mechanic mechanic;

	@Basic
	private Date dtmBooking;
	private String strObservations;

}
