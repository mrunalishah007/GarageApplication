package com.garage.manage.service;

import java.util.List;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Garage;
import com.garage.manage.entity.Supplier;

public interface ManageGarageService {

	Garage createGarage(Garage garage);
	Garage updateGarage(Garage garage);
	List<Garage> fetchGarage();
	boolean deleteGarage(Garage garage);	
}
