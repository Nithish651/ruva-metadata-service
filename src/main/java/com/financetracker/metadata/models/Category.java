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
@Table(name="category",schema="metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	@SequenceGenerator(name = "category_seq_gen", sequenceName = "category_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq_gen")
	@Column(name="category_id")
	private Integer categoryId;
	
	@Column(name="category_name")
	private String categoryName;
}
