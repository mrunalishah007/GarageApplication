package com.garage.manage.service;

import java.util.List;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Garage;
import com.garage.manage.entity.Order;
import com.garage.manage.entity.Supplier;

public interface ManageOrderService {

	Order createOrder(Order order);
	List<Order> fetchOrders();
	Order updateOrder(Order order);
	void deleteOrder(Order order);
}
