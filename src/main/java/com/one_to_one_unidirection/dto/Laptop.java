package com.one_to_one_unidirection.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop{

	@Id
	private int id;
	private String name;
	private String color;
	private double price;
}
