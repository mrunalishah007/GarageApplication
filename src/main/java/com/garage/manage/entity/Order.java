package com.garage.manage.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Builder
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String orderId;
	private Integer orderQuantity;
	private String autopartName;
	private String autopartManufacturingCompany;
	private String vehicleType;
	//private String supplierName;
	private String deliveryLocation;
	private ZonedDateTime orderDate;
	
	  public String getOrderId() { return orderId; } public Integer
	  getOrderQuantity() { return orderQuantity; } public void
	  setOrderQuantity(Integer orderQuantity) { this.orderQuantity = orderQuantity;
	  } public String getAutopartName() { return autopartName; } public void
	  setAutopartName(String autopartName) { this.autopartName = autopartName; }
	  public String getAutopartManufacturingCompany() { return
	  autopartManufacturingCompany; } public void
	  setAutopartManufacturingCompany(String autopartManufacturingCompany) {
	  this.autopartManufacturingCompany = autopartManufacturingCompany; } public
	  String getVehicleType() { return vehicleType; } public void
	  setVehicleType(String vehicleType) { this.vehicleType = vehicleType; } 
	  /*public
	
	 * String getSupplierName() { return supplierName; } public void
	 * setSupplierName(String supplierName) { this.supplierName = supplierName; }
	 */
	  public ZonedDateTime getOrderDate() { return orderDate; } public void
	  setOrderDate(ZonedDateTime now) { this.orderDate = now; }
	 
	

}
