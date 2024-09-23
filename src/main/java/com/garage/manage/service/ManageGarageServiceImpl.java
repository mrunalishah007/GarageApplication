package com.garage.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.manage.entity.Garage;
import com.garage.manage.repository.ManageGarageRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManageGarageServiceImpl implements  ManageGarageService{
	
	@Autowired
	ManageGarageRepository repo;

@Override
public Garage createGarage(Garage garage) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Garage updateGarage(Garage garage) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Garage> fetchGarage() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean deleteGarage(Garage garage) {
	// TODO Auto-generated method stub
	return false;
}
}
