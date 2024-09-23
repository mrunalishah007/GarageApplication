package com.garage.manage.service;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.manage.entity.Supplier;
import com.garage.manage.repository.ManageSupplierRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManageSupplierServiceImpl implements  ManageSupplierService{
		
	@Autowired
	ManageSupplierRepository suppRepo;
	
	/*
	 * @Autowired AutoPart aPart;
	 */
	
	private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
	@Override
	public Supplier addSupplier(Supplier supplier) {
		if(Objects.isNull(supplier))return null;
		return (Supplier) suppRepo.save(supplier);
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		boolean result = false;
		try {
			suppRepo.delete(supplier);
			result = true;
			
		} catch (Exception e) {
			result = false;
		};
		return result;
		
		
	}

	@Override
	public List<Supplier> fetchSupplierList() {
		List<Supplier> supplierList = suppRepo.findAll();
		//log.info("Supplier List: ",supplierList);
		return supplierList;
	}
}
