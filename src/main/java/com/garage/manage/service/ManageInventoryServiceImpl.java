package com.garage.manage.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Order;
import com.garage.manage.entity.Supplier;
import com.garage.manage.repository.ManageAutopartRepository;
import com.garage.manage.repository.ManageOrderRepository;
import com.garage.manage.repository.ManageSupplierRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManageInventoryServiceImpl implements  ManageInventoryService{
	
	@Autowired
	ManageAutopartRepository repo;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AutoPart> addAutoParts(List<AutoPart> parts) {
		if(parts == null || parts.isEmpty() )return null;
		List<AutoPart> saveAutoParts = (List<AutoPart>) repo.saveAll(parts);
		return saveAutoParts;
	}

	@Override
	public List<AutoPart> fetchAutoParts(){
		return (List<AutoPart>)repo.findAll();
	}

	@Override
	public AutoPart updateAutoPart(AutoPart part) throws Exception {
		Optional<AutoPart> p = repo.findById(part.getId());
		if(!p.isPresent())throw new Exception("Autopart Not available to update");
		AutoPart existingPart = p.get();
		existingPart.setAutoPartName(part.getAutoPartName());
		existingPart.setManufacturingCompany(part.getManufacturingCompany());
		existingPart.setManufacturingDate(part.getManufacturingDate());
		existingPart.setPrice(part.getPrice());
		existingPart.setThresholdQuantity(part.getThresholdQuantity());
		existingPart.setMinOrderQuantity(part.getMinOrderQuantity());
		existingPart.setAvailableQuantity(part.getAvailableQuantity());
		existingPart.setSupplier(part.getSupplier());
		existingPart.setGarageName(part.getGarageName());
		existingPart.setVehicleType(part.getVehicleType());
		return repo.save(existingPart);
	}

	@Override
	public void deleteAutoPart(AutoPart part) {
		repo.delete(part);;
		
	}

}
