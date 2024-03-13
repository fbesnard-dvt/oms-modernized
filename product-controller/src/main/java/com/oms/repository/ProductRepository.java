package com.oms.repository;

import com.oms.entity.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
	Optional<Product> findByName(String name);
	List<Product> findByDescriptionContainingIgnoreCase(String text);
}
