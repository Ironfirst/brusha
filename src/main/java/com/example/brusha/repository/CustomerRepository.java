package com.example.brusha.repository;

import com.example.brusha.models.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
