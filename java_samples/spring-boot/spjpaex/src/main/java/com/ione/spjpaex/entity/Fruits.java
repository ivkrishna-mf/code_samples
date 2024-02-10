package com.ione.spjpaex.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Fruits")
public class Fruits {
	
	public Fruits(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "fid")
	private long fruitId;
	
	
	
	private String name;
	
	private String color;
	
	
	
	
	
	
	
	

	

}
