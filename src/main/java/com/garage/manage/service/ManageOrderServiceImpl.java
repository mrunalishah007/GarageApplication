package com.garage.manage.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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
public class ManageOrderServiceImpl implements ManageOrderService {
	private static final Logger log = LoggerFactory.getLogger(ManageOrderService.class);

	@Autowired
	ManageOrderRepository orderrepo;

	@Autowired
	ManageAutopartRepository repo;

	@Scheduled(cron = "0 5 1 15 * *") // cron can be configured as required in prop file and utilised
	private void autoOrderCreationForIntSupplier() {
		// Here reactive spring can be used for faster execution or parallel threads can
		// also be spun up
		List<AutoPart> autoparts = repo.findAutoPartBySupplier("International");
		// validate autopart list
		List<Order> orderList = new ArrayList<Order>();
		// proper validations to be placed in here
		Supplier supplierDetails = autoparts.get(0).getSupplier();
		for (AutoPart part : autoparts) {
			if (isOrderGenerationRequired(part)) {
				// autoPartsToBeOrdered.add(part);
				log.info("Order added for autopart {} {}", part.getAutoPartName(), part.getMinOrderQuantity());
				orderList.add(createApOrder(part));
			}

		}
		triggerOrderToSupplier(orderList, supplierDetails);

	}

	@Scheduled(cron = "0 5 18 15 * *") //cron can be configured as required in prop file and utilised
	private void autoOrderCreationForLocalSupplier() {
		//Here reactive spring can be used for faster execution or parallel threads can also be spun up
		List<AutoPart> autoparts = repo.findAutoPartBySupplier("Local");
		//validate autopart list
		List<Order> orderList = new ArrayList<Order>();
		//proper validations to be placed in here
		Supplier supplierDetails = autoparts.get(0).getSupplier();
		for(AutoPart part : autoparts) {
			if(isOrderGenerationRequired(part)) {
				//autoPartsToBeOrdered.add(part);
				log.info("Order added for autopart {} {}",part.getAutoPartName(),part.getMinOrderQuantity());
				orderList.add(createApOrder(part));
			}
			
		}
		triggerOrderToSupplier(orderList, supplierDetails);
		
		
	}

	private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

	private boolean isOrderGenerationRequired(AutoPart part) {
		boolean response = false;
		if (part.getAvailableQuantity() < part.getThresholdQuantity())
			response = true;
		return response;
	}

	private void triggerOrderToSupplier(List<Order> orderList, Supplier supp) {
		// validateOrder
		//if rest endpoint to be called
		try {
			ResponseEntity<Order> response = postRequest(orderList, supp.getSupplierBaseUrl());
			// validate and handle the response
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Order createApOrder(AutoPart p) {

		Order order = new Order();
		// All validations need to be handled here
		order.setOrderQuantity(p.getMinOrderQuantity());
		order.setAutopartName(p.getAutoPartName());
		order.setAutopartManufacturingCompany(p.getManufacturingCompany());
		order.setVehicleType(p.getVehicleType());
		order.setOrderDate(ZonedDateTime.now());
		return order;
	}

	private ResponseEntity<Order> postRequest(List<Order> orders, String supplierBaseURL) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI("http://localhost:" + supplierBaseURL + "/placeOrder/");

		ResponseEntity<Order> result = restTemplate.postForEntity(uri, orders, Order.class);
		log.info(result.getStatusCode().toString());
		log.info(result.getBody().toString());
		return result;

	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> fetchOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
	}
}
