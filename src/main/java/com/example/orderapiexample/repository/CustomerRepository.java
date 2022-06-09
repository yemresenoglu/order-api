package com.example.orderapiexample.repository;

import com.example.orderapiexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.isDeleted = ?1")
    Collection<Customer> findAllCustomersByDeleteStatusByJPQL(boolean status);
    Date endDate, OffsetDateTime startDate

}
