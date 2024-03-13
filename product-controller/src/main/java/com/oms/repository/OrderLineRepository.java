package com.oms.repository;

import com.oms.entity.OrderLine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, String> {	
	List<OrderLine> findByCustomerSKU(String sku);
}
