package com.ismail.tech.logisticsdelivery.services;

import com.ismail.tech.logisticsdelivery.data.repositories.CustomerRepository;
import com.ismail.tech.logisticsdelivery.data.repositories.OrderItemRepository;
import com.ismail.tech.logisticsdelivery.dtos.request.LoginRequest;
import com.ismail.tech.logisticsdelivery.dtos.request.OrderItemDetailsRequest;
import com.ismail.tech.logisticsdelivery.dtos.request.RegisterRequest;
import com.ismail.tech.logisticsdelivery.exception.InvalidDetailsException;
import com.ismail.tech.logisticsdelivery.exception.UserExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CustomerServiceImplTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @BeforeEach
    public void doThisBeforeTest(){

        customerRepository.deleteAll();
    }

    @Test
    public void testThatACustomerCanRegister(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("ismail");
        registerRequest.setPassword("password");
        customerService.register(registerRequest);
        assertThrows(UserExistException.class, () -> customerService.register(registerRequest));
    }
    @Test
    public void registerCustomer_loginWithWrongPassword_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setPassword("password");
        registerRequest.setUsername("ismail");
        customerService.register(registerRequest);
        loginRequest.setPassword("wrongPassword");
        loginRequest.setUsername("ismail");
        assertThrows(InvalidDetailsException.class,
                () -> customerService.login(loginRequest));

    }
    @Test
    public void registerCustomer_loginWithWrongUsername_throwsExceptionTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setPassword("password");
        registerRequest.setUsername("ismail");
        customerService.register(registerRequest);
        loginRequest.setUsername("wrongUsername");
        loginRequest.setPassword("password");
        assertThrows(InvalidDetailsException.class,
                () -> customerService.login(loginRequest));
    }
    @Test
    public void testThatWhenACustomerPlacesAnOrder_OrderIncreases(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("ismail");
        registerRequest.setPassword("password");
        customerService.register(registerRequest);
        loginRequest.setUsername("ismail");
        loginRequest.setPassword("password");
        OrderItemDetailsRequest orderDetailsRequest = new OrderItemDetailsRequest();
        orderDetailsRequest.setType("Edible");
        orderDetailsRequest.setDescription("carbonated Drinks");
        orderDetailsRequest.setProductNumber("234y4");
        orderDetailsRequest.setCustomerName("ismail");
        customerService.placeOrder(orderDetailsRequest);
        assertEquals(1,orderItemRepository.count());
    }
    @Test
    public void testThatACustomerCAnAddMoreOrder() {
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("ismail");
        registerRequest.setPassword("password");
        customerService.register(registerRequest);
        loginRequest.setUsername("ismail");
        loginRequest.setPassword("password");
        customerService.login(loginRequest);
        OrderItemDetailsRequest orderDetailsRequest = new OrderItemDetailsRequest();
        orderDetailsRequest.setType("Edible");
        orderDetailsRequest.setDescription("carbonated Drinks");
        orderDetailsRequest.setProductNumber("234y4");
        orderDetailsRequest.setCustomerName("ismail");
        customerService.placeOrder(orderDetailsRequest);
        orderDetailsRequest.setType("clothing");
        orderDetailsRequest.setDescription("wrist watch");
        orderDetailsRequest.setProductNumber("234y4");
        orderDetailsRequest.setCustomerName("ismail");
        customerService.placeOrder(orderDetailsRequest);
        assertEquals(2,orderItemRepository.count());

    }

}