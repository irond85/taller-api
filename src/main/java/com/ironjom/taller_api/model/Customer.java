package com.ironjom.taller_api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Customers")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCustomer;

	@NotNull(message = "El strNombre no puede ser nulo")
	private String strName;
	@NotNull(message = "El strDocument no puede ser nulo")
	private String strDocument;
	@NotNull(message = "El strPhone no puede ser nulo")
	private String strPhone;
	@NotNull(message = "El strEmail no puede ser nulo")
	private String strEmail;

	@OneToMany(mappedBy = "customer")
	private List<Vehicle> vehicles;

	@OneToMany(mappedBy = "customer")
	private List<Booking> bookings;

//	*   `@NotNull`: El campo no debe ser nulo.
//    *   `@NotEmpty`: El campo no debe estar vacío (para Strings, Collections, etc.).
//    *   `@Size`: El tamaño del campo debe estar dentro de un rango específico.
//    *   `@Email`: El campo debe ser una dirección de correo electrónico válida.
//    *   `@Min`, `@Max`: El valor del campo debe estar dentro de un rango numérico.

}
