package com.garage.manage.repository;

import org.springframework.stereotype.Repository;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface ManageOrderRepository extends JpaRepository<Order, Long> {

}
