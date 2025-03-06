package com.ironjom.taller_api.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicles")
@Data
@NoArgsConstructor
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idVehicle;

	@ManyToOne
	@JoinColumn(name = "id_customer_v")
	@NotNull(message = "El customer no puede ser nulo")
	private Customer customer;

	@OneToMany(mappedBy = "vehicle")
	private List<Booking> bookings;

	@NotNull(message = "El strBrand no puede ser nulo")
	private String strBrand;
	@NotNull(message = "El strModel no puede ser nulo")
	private String strModel;
	@NotNull(message = "El strYear no puede ser nulo")
	private String strYear;

	private String strKm;
	private Date dtmSOAT;
	private Date dtmTecno;

}
