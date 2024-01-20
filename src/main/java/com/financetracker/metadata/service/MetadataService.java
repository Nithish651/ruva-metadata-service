package com.financetracker.metadata.service;

import java.util.List;

import com.financetracker.metadata.models.Category;
import com.financetracker.metadata.models.PaymentType;

public interface MetadataService {

	List<PaymentType> getAllPaymentTypes();
	List<Category> getAllCatgeories();
}
