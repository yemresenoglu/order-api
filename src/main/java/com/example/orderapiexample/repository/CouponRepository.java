package com.example.orderapiexample.repository;

import com.example.orderapiexample.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("SELECT c FROM Coupon c WHERE c.order.id = ?1")
    Set<Coupon> findCouponByOrderID(Long orderID);
}
