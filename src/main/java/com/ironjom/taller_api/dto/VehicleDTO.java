package com.ironjom.taller_api.dto;

import java.util.Date;

import lombok.Data;

@Data
public class VehicleDTO {
	private Long idVehicle;
	private Long idCustomer;
	private String strBrand;
	private String strModel;
	private String strYear;
	private String strKm;
	private Date dtmSOAT;
	private Date dtmTecno;
	private String strPlaca;
}
