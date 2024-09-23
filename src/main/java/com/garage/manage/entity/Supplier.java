package com.garage.manage.entity;

import lombok.Data;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Supplier implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	private String supplierName;
	private String supplierAddress;
	private String supplierContact;
	private String supplierBaseUrl;
	private boolean discountTimeApplicable;
	private String supplierType;
	

}
