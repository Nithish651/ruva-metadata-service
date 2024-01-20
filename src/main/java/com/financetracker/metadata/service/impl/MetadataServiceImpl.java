package com.financetracker.metadata.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financetracker.metadata.models.Category;
import com.financetracker.metadata.models.PaymentType;
import com.financetracker.metadata.repository.CategoryRepository;
import com.financetracker.metadata.repository.PaymentTypeRepository;
import com.financetracker.metadata.service.MetadataService;


@Service
public class MetadataServiceImpl implements MetadataService {
	
	private PaymentTypeRepository paymentTypeRepository;
	private CategoryRepository categoryRepository;

	public MetadataServiceImpl(PaymentTypeRepository paymentTypeRepository, CategoryRepository categoryRepository) {
		this.paymentTypeRepository = paymentTypeRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<PaymentType> getAllPaymentTypes() {
		return paymentTypeRepository.findAll();
	}

	@Override
	public List<Category> getAllCatgeories() {
		return categoryRepository.findAll();
	}

}
