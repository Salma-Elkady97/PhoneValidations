package com.example.phonevalidation.service.impl;

import com.example.phonevalidation.Model.CustomerModel;
import com.example.phonevalidation.entity.Customer;
import com.example.phonevalidation.repo.CustomerRepository;
import com.example.phonevalidation.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CustomerModel> getAllPhoneNumbers() {
        List<CustomerModel> customerModelList = new ArrayList<>();
        Type listType = new TypeToken<List<CustomerModel>>() {
        }.getType();
        List<Customer> customers = customerRepository.findAll();
        customerModelList = modelMapper.map(customers, listType);
        return customerModelList;

    }
}
