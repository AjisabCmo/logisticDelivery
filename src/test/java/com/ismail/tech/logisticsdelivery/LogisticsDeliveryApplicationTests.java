package com.ismail.tech.logisticsdelivery;

import com.ismail.tech.logisticsdelivery.data.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogisticsDeliveryApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;


}
