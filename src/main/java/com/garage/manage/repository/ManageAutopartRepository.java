package com.garage.manage.repository;

import org.springframework.stereotype.Repository;

import com.garage.manage.entity.AutoPart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface ManageAutopartRepository extends JpaRepository<AutoPart, Long> {
	@Query( 
	        nativeQuery = true, 
	        value 
	        = "SELECT ap FROM garage.auto_part ap join garage.supplier s on ap.supplier = s.supplier_id where ap.supplier_type=:supplierType") 
	       List<AutoPart> findAutoPartBySupplier(@Param("supplierType") String supplierType); 
	}
