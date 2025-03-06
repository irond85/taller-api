package com.ironjom.taller_api.dto;

import lombok.Data;

@Data
public class CustomerDTO {
	private Long idCustomer;
	private String strDocument;
	private String strName;
	private String strPhone;
	private String strEmail;
	private Integer intNumberOfVehicles;
	private Integer intNumberOfBookings;
}
