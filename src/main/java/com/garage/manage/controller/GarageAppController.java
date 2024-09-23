package com.garage.manage.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Supplier;
import com.garage.manage.service.ManageGarageService;
import com.garage.manage.service.ManageInventoryService;
import com.garage.manage.service.ManageOrderService;
import com.garage.manage.service.ManageSupplierService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@RestController
@RequestMapping("/manageInventory")
@Slf4j
public class GarageAppController {
	
	@Autowired
	private ManageInventoryService service;
	@Autowired
	private ManageGarageService gservice;
	@Autowired
	private ManageOrderService orderService;
	@Autowired
	private ManageSupplierService supplierService;
	
	@PostMapping(value= "/addParts",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutoPart>> addAutoParts(@RequestBody List<AutoPart> autoParts) {
		try{
			List<AutoPart> autoPartsToAdd = autoParts;
		
		if (autoPartsToAdd == null || autoPartsToAdd.isEmpty())
			return new ResponseEntity<List<AutoPart>>(HttpStatus.NO_CONTENT);	
		
		return new ResponseEntity<List<AutoPart>>(service.addAutoParts(autoPartsToAdd),HttpStatus.CREATED);
		} catch(Exception ex) {
			return new ResponseEntity<List<AutoPart>>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@PatchMapping(value= "/updateParts",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AutoPart>> updateAutoParts(@RequestBody List<AutoPart> autoParts) {
		try {
			List<AutoPart> updatedAutoParts = null;
			if (autoParts == null || autoParts.isEmpty())
				return new ResponseEntity<List<AutoPart>>(HttpStatus.NO_CONTENT);
			
			for(AutoPart part : autoParts) {
				if(Objects.isNull(part))continue;
				updatedAutoParts.add(service.updateAutoPart(part));
			} return new ResponseEntity<List<AutoPart>>(updatedAutoParts,HttpStatus.OK);
			
		} catch(Exception ex) {
			return new ResponseEntity<List<AutoPart>>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
	}
	
	@DeleteMapping(value= "/deleteParts",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteAutoParts(@RequestBody List<AutoPart> autoParts) {
		return null;
	}
	
	@PostMapping(value= "/addSupplier",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
		try{
			
		
		if (supplier == null)
			return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);	
		
		return new ResponseEntity<Supplier>(supplierService.addSupplier(supplier),HttpStatus.CREATED);
		} catch(Exception ex) {
			return new ResponseEntity<Supplier>(HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	
	@PatchMapping(value= "/updateSupplier",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> updateSupplier(@RequestBody Supplier supplier) {
		try{
			if (supplier == null)
				return new ResponseEntity<Supplier>(HttpStatus.NO_CONTENT);	
			
			return new ResponseEntity<Supplier>(supplierService.updateSupplier(supplier),HttpStatus.CREATED);
			} catch(Exception ex) {
				return new ResponseEntity<Supplier>(HttpStatus.INTERNAL_SERVER_ERROR);	
			}
	}
	
	@DeleteMapping(value= "/deleteSupplier",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteSupplier(@RequestBody Supplier supplier) {
		try{
			if (supplier == null)
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);	
			
			return new ResponseEntity<Object>(supplierService.deleteSupplier(supplier),HttpStatus.CREATED);
			} catch(Exception ex) {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);	
			}
	}
	
}
