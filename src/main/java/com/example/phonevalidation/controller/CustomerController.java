package com.example.phonevalidation.controller;

import com.example.phonevalidation.Model.CustomerModel;
import com.example.phonevalidation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/phones")
    public List<CustomerModel> getAllPhoneNumbers() {
        List<CustomerModel> customerModelList = new ArrayList<>();
        customerModelList = customerService.getAllPhoneNumbers();
        return customerModelList;
    }

    @GetMapping(value = "/phones", params = "country")
    public List<CustomerModel> getPhonesOfSpecificCountry(@RequestParam("country") String country) {
        List<CustomerModel> customerModel = new ArrayList<>();
        customerModel = customerService.getPhonesOfSpecificCountry(country);
        return customerModel;

    }
    @GetMapping(value = "/phones/valid")
    public List<CustomerModel> getValidPhones() {
        List<CustomerModel> customerModel = new ArrayList<>();
        customerModel = customerService.getValidPhones();
        return customerModel;

    }
    @GetMapping(value = "/phones/notvalid")
    public List<CustomerModel> getNonValidPhones() {
        List<CustomerModel> customerModel = new ArrayList<>();
        customerModel = customerService.getNonValidPhones();
        return customerModel;

    }
    @GetMapping(value = "/phones/valid", params = "country")
    public List<CustomerModel> getValidPhonesForCountry(@RequestParam("country") String country)
    {
        List<CustomerModel> customerModel = new ArrayList<>();
        customerModel = customerService.getValidPhonesForCountry(country);
        return customerModel;
    }
    @GetMapping(value = "/phones/notvalid", params = "country")
    public List<CustomerModel> getNotValidPhonesForCountry(@RequestParam("country") String country)
    {
        List<CustomerModel> customerModel = new ArrayList<>();
        customerModel = customerService.getNotValidPhonesForCountry(country);
        return customerModel;
    }



}
