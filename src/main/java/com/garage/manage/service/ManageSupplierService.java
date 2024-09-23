package com.garage.manage.service;

import java.util.List;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Garage;
import com.garage.manage.entity.Supplier;

public interface ManageSupplierService {
	Supplier addSupplier(Supplier supplier);
	List<Supplier> fetchSupplierList();
	Supplier updateSupplier(Supplier supplier);
	boolean deleteSupplier(Supplier supplier);
	
}
