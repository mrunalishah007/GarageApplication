package com.garage.manage.repository;

import org.springframework.stereotype.Repository;

import com.garage.manage.entity.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface ManageSupplierRepository extends JpaRepository<Supplier, String> {

}
