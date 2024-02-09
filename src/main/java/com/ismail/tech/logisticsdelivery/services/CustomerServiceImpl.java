package com.ismail.tech.logisticsdelivery.services;

import com.ismail.tech.logisticsdelivery.data.model.Customer;
import com.ismail.tech.logisticsdelivery.data.repositories.CustomerRepository;
import com.ismail.tech.logisticsdelivery.dtos.request.LoginRequest;
import com.ismail.tech.logisticsdelivery.dtos.request.OrderItemDetailsRequest;
import com.ismail.tech.logisticsdelivery.dtos.request.RegisterRequest;
import com.ismail.tech.logisticsdelivery.exception.InvalidDetailsException;
import com.ismail.tech.logisticsdelivery.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ismail.tech.logisticsdelivery.utils.Mapper.map;

@Service

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(RegisterRequest registerRequest) {
        if(userExist(registerRequest.getUsername())) throw new UserExistException(registerRequest.getUsername()+ "already exist");
        Customer customer = map(registerRequest);
        customerRepository.save(customer);


    }


    @Override
    public void login(LoginRequest loginRequest) {
        Customer foundCustomer = customerRepository.findCustomerByUsername(loginRequest.getUsername());
        if(!userExist(loginRequest.getUsername())) throw new InvalidDetailsException(loginRequest.getUsername()+ "user dosnt exist");
        if (!foundCustomer.getPassword().equals(loginRequest.getPassword())) throw new InvalidDetailsException(loginRequest.getPassword() + "password doesnt exist");
        foundCustomer.setLocked(false);
        customerRepository.save(foundCustomer);
    }

    @Override
    public void placeOrder(OrderItemDetailsRequest orderDetailsRequest) {

    }


    private boolean userExist(String username) {
        Customer foundCustomer = customerRepository.findCustomerByUsername(username);
        return  foundCustomer != null;
    }




    @Override
    public void placeOrderForAFriend() {

    }
}
