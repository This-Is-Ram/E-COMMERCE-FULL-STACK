package com.ram.cart_service.repository;

import com.ram.cart_service.model.CartResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartResponse,Long> {
    List<CartResponse> findByUserEmail(String email);
}
