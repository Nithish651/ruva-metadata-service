package com.financetracker.metadata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payment_type",schema = "metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType {
	
	@Id
	@SequenceGenerator(name = "payment_type_seq_gen", sequenceName = "payment_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_type_seq_gen")
	private Integer id;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="card_number")
	private String cardNumber;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="logo_url")
	private String logoUrl;	
}
