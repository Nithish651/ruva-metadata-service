package com.financetracker.metadata.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financetracker.common.model.CustomAPIRespose;
import com.financetracker.common.utils.CommonUtils;
import com.financetracker.metadata.models.Category;
import com.financetracker.metadata.models.PaymentType;
import com.financetracker.metadata.service.MetadataService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class MetaDatacontroller {

	private MetadataService metadataService;

	public MetaDatacontroller(MetadataService metadataService) {
		this.metadataService = metadataService;
	}

	@GetMapping("/metadata/v1/paymentTypes")
	@Operation(summary = "Get payment types", description = "Get all the payment types", tags = {"Metadata services" })
	public CustomAPIRespose<List<PaymentType>> getAllPaymentTypes() {
		return CommonUtils.buildResponse(metadataService.getAllPaymentTypes(), 200,
				"Successfully retrieved payment types",
				ServletUriComponentsBuilder.fromCurrentRequest().build().toUri().getPath(), "SUCCESS");
	}

	@GetMapping("/metadata/v1/categories")
	@Operation(summary = "Get payment types", description = "Get all the expense categories", tags = {"Metadata services" })
	public CustomAPIRespose<List<Category>> getAllCategories(){
		return CommonUtils.buildResponse(metadataService.getAllCatgeories(), 200, 
				"Successfully retrieved categories", 
				ServletUriComponentsBuilder.fromCurrentRequest().build().toUri().getPath(), "SUCCESS");
	}

}
