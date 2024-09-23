package com.garage.manage.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "auto_parts")
public class AutoPart implements Serializable {
	private static final long serialVersionUID = -68683096286892674L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String autoPartName;
	private String manufacturingCompany;
	private String manufacturingDate;
	private Long price;
	private Integer thresholdQuantity;
	private Integer minOrderQuantity;
	private Integer availableQuantity;
	private Supplier supplier;
	private String garageName;
	private String vehicleType;

	public Long getId() {
		return id;
	}
	public String getAutoPartName() {
		return autoPartName;
	}

	public void setAutoPartName(String autoPartName) {
		this.autoPartName = autoPartName;
	}

	public String getManufacturingCompany() {
		return manufacturingCompany;
	}

	public void setManufacturingCompany(String manufacturingCompany) {
		this.manufacturingCompany = manufacturingCompany;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getThresholdQuantity() {
		return thresholdQuantity;
	}

	public void setThresholdQuantity(Integer thresholdQuantity) {
		this.thresholdQuantity = thresholdQuantity;
	}

	public Integer getMinOrderQuantity() {
		return minOrderQuantity;
	}

	public void setMinOrderQuantity(Integer minOrderQuantity) {
		this.minOrderQuantity = minOrderQuantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getGarageName() {
		return garageName;
	}

	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
