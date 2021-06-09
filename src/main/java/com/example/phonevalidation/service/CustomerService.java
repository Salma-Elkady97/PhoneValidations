package com.example.phonevalidation.service;

import com.example.phonevalidation.Model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<CustomerModel> getAllPhoneNumbers();
}
