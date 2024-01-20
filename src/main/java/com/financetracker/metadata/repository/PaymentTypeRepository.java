package com.financetracker.metadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financetracker.metadata.models.PaymentType;



public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

}
