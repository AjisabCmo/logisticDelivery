package com.ismail.tech.logisticsdelivery.data.repositories;

import com.ismail.tech.logisticsdelivery.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String>{
    Customer findCustomerByUsername(String username);
}
