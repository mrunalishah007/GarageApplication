package com.garage.manage.service;

import java.util.List;

import com.garage.manage.entity.AutoPart;
import com.garage.manage.entity.Garage;
import com.garage.manage.entity.Supplier;

public interface ManageInventoryService {

	List<AutoPart> addAutoParts(List<AutoPart> parts);
	List<AutoPart> fetchAutoParts();
	AutoPart updateAutoPart(AutoPart parts) throws Exception;
	void deleteAutoPart(AutoPart parts);
}
