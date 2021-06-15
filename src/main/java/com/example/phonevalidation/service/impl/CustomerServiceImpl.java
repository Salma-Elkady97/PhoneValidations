package com.example.phonevalidation.service.impl;

import com.example.phonevalidation.model.CustomerModel;
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
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private String cameroonRegex = " \\(237\\)\\ ?[2368]\\d{7,8}$";
    private String ethiopiaRegex = "\\(251\\)\\ ?[1-59]\\d{8}$";
    private String moroccoRegex = "\\(212\\)\\ ?[5-9]\\d{8}$";
    private String mozambiqueRegex = " \\(258\\)\\ ?[28]\\d{7,8}$";
    private String ugandaRegex = " \\(256\\)\\ ?\\d{9}$";
    private Pattern cameroonPattern = Pattern.compile(cameroonRegex);
    private Pattern ethiopiaPattern = Pattern.compile(ethiopiaRegex);
    private Pattern moroccoPattern = Pattern.compile(moroccoRegex);
    private Pattern mozambiquePattern = Pattern.compile(mozambiqueRegex);
    private Pattern ugandaPattern = Pattern.compile(ugandaRegex);
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
        System.out.println("codee=== " + code);
        Type listType = new TypeToken<List<CustomerModel>>() {
        }.getType();
        List<Customer> customers = customerRepository.getPhonesOfSpecificCountry(code);
        List<CustomerModel> customerModelList = modelMapper.map(customers, listType);
        return customerModelList;

    }

    @Override
    public List<CustomerModel> getValidPhones() {
        List<CustomerModel> customerModelList = new ArrayList<>();
        Type listType = new TypeToken<List<CustomerModel>>() {
        }.getType();
        List<Customer> customers = customerRepository.findAll();
        customerModelList = modelMapper.map(customers, listType);
        List<CustomerModel> validPhones = new ArrayList<>();

        for (int i = 0; i < customerModelList.size(); i++) {
            if (cameroonPattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || ethiopiaPattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || moroccoPattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || mozambiquePattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || ugandaPattern.matcher(customerModelList.get(i).getPhone()).matches()
            )
            {
                validPhones.add(customerModelList.get(i));

            }
        }

        return validPhones;
    }

    @Override
    public List<CustomerModel> getNonValidPhones() {
        List<CustomerModel> customerModelList = new ArrayList<>();
        Type listType = new TypeToken<List<CustomerModel>>() {
        }.getType();
        List<Customer> customers = customerRepository.findAll();
        customerModelList = modelMapper.map(customers, listType);
        List<CustomerModel> notValidPhones = new ArrayList<>();

        for (int i = 0; i < customerModelList.size(); i++) {
            if (!(cameroonPattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || ethiopiaPattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || moroccoPattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || mozambiquePattern.matcher(customerModelList.get(i).getPhone()).matches()
                    || ugandaPattern.matcher(customerModelList.get(i).getPhone()).matches())
            )
            {

                notValidPhones.add(customerModelList.get(i));
            }

        }

        return notValidPhones;
    }

    @Override
    public List<CustomerModel> getValidPhonesForCountry(String country) {
        List<CustomerModel> customerValidPhoneNumbers = getValidPhones();
        List<CustomerModel> customerValidPhoneNumbersForCountry = new ArrayList<>();
        String code = null;
        switch (country) {
            case "Cameroon":
                code = "(237)";
                break;
            case "Ethiopia":
                code = "(251)";
                break;
            case "Morocco":
                code = "(212)";
                break;
            case "Mozambique":
                code = "(258)";
                break;
            case "Uganda":
                code = "(256)";
                break;
            default:
                System.out.println("Not Available Country");

        }
        for(int i = 0 ; i <customerValidPhoneNumbers.size(); i++)
        {
            if(customerValidPhoneNumbers.get(i).getPhone().contains(code))
            {
                customerValidPhoneNumbersForCountry.add(customerValidPhoneNumbers.get(i));
            }
        }
        return customerValidPhoneNumbersForCountry;



    }

    @Override
    public List<CustomerModel> getNotValidPhonesForCountry(String country) {
        List<CustomerModel> customerNotValidPhoneNumbers = getNonValidPhones();
        List<CustomerModel> customerNotValidPhoneNumbersForCountry = new ArrayList<>();
        String code = null;
        switch (country) {
            case "Cameroon":
                code = "(237)";
                break;
            case "Ethiopia":
                code = "(251)";
                break;
            case "Morocco":
                code = "(212)";
                break;
            case "Mozambique":
                code = "(258)";
                break;
            case "Uganda":
                code = "(256)";
                break;
            default:
                System.out.println("Not Available Country");

        }
        for(int i = 0 ; i <customerNotValidPhoneNumbers.size(); i++)
        {
            if(customerNotValidPhoneNumbers.get(i).getPhone().contains(code))
            {
                customerNotValidPhoneNumbersForCountry.add(customerNotValidPhoneNumbers.get(i));
            }
        }
        return customerNotValidPhoneNumbersForCountry;


    }
}
