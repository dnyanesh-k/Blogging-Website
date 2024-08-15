package com.sunbeam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {
	private String adrLine1;
	
	private String adrLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
	
	private String phoneNo;
	
}
