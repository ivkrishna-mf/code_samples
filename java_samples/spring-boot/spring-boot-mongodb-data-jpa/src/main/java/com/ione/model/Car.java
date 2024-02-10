package com.ione.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Car {

	@Id
	private int carId;
	
	private String comanyName;
	
	private String type;
	
	public Car(String companyName, String type){
		this.comanyName = companyName;
		this.type = type;
	}
	
}
