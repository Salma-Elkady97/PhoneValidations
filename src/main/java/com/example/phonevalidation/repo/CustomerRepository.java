package com.example.phonevalidation.repo;

import com.example.phonevalidation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value ="from Customer c where phone like ?1")
    List<Customer> getPhonesOfSpecificCountry(String code);

}
