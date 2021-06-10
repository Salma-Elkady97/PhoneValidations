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

    @Override
    public List<CustomerModel> getPhonesOfSpecificCountry(String country) {
        String code = null;
        switch (country) {
            case "Cameroon":
                code = "(237)%";
                break;
            case "Ethiopia":
                code = "(251)%";
                break;
            case "Morocco":
                code = "(212)%";
                break;
            case "Mozambique":
                code = "(258)%";
                break;
            case "Uganda":
                code = "(256)%";
                break;
            default:
                System.out.println("Not Available Country");

        }
        System.out.println("codee=== "+code);
        Type listType = new TypeToken<List<CustomerModel>>() {
        }.getType();
        List<Customer> customers = customerRepository.getPhonesOfSpecificCountry(code);
        List<CustomerModel> customerModelList = modelMapper.map(customers, listType);
        return customerModelList;

    }

    @Override
    public List<CustomerModel> getValidPhones() {
        return null;
    }
}
