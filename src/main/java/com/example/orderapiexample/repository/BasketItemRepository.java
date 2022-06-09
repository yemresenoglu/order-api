package com.example.orderapiexample.repository;

import com.example.orderapiexample.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {

    @Query("SELECT b FROM BasketItem b WHERE b.basket.id = ?1")
    Collection<BasketItem> findAllOneBasketItem(Long id);
}
