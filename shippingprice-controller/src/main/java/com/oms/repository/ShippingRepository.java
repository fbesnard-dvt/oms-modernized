package com.oms.repository;

import com.oms.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository  extends JpaRepository<Shipping ,String> {
}
