package com.ismail.tech.logisticsdelivery.controller;

import com.ismail.tech.logisticsdelivery.dtos.request.RegisterRequest;
import com.ismail.tech.logisticsdelivery.dtos.response.ApiResponse;
import com.ismail.tech.logisticsdelivery.dtos.response.RegisterResponse;
import com.ismail.tech.logisticsdelivery.exception.LogisticsDeliveryException;
import com.ismail.tech.logisticsdelivery.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogisticsController {
    @Autowired
    private CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = new RegisterResponse();
        try{
            customerService.register(registerRequest);
            registerResponse.setMessage("Account created successfully");
            return new ResponseEntity<>(new ApiResponse(true, registerResponse), HttpStatus.CREATED);
        }
        catch(LogisticsDeliveryException ex){
            registerResponse.setMessage(ex. getMessage());
            return new ResponseEntity<>(new ApiResponse(false, registerResponse), HttpStatus.BAD_REQUEST);
        }
    }

}
