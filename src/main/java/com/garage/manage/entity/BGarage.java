package com.garage.manage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BGarage extends Garage implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String name;
	private String location;
	private Date startDate;
	/*
	 * @Autowired private Map<String, Vehicle> vehicleServiceable;
	 */
	@Autowired
	private List<Supplier> supplierList;
	

}
