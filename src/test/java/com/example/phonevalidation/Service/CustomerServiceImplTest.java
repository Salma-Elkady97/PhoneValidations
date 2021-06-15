package com.example.phonevalidation.Service;

import com.example.phonevalidation.entity.Customer;
import com.example.phonevalidation.model.CustomerModel;
import com.example.phonevalidation.repo.CustomerRepository;
import com.example.phonevalidation.service.impl.CustomerServiceImpl;
import com.example.phonevalidation.utils.TestHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Type;
import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CustomerServiceImplTest {
    private TestHelper testHelper = new TestHelper();
    @Mock
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerServiceImpl customerService;
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    void getAllCutomers()
    {
        List<Customer> cutomerList = testHelper.getAllCustomers();
        System.out.println(cutomerList);
        when(customerRepository.findAll()).thenReturn(cutomerList);
        List<CustomerModel> allCutomers = customerService.getAllPhoneNumbers();
        Type listType = new TypeToken<List<Customer>>() {
        }.getType();
        List<Customer> customers = modelMapper.map(allCutomers , listType);
        //assertThat(allCutomers.size()).isEqualTo(3);
        for(int i = 0 ; i<cutomerList.size() ;i++)
        {
            testEquals(cutomerList.get(i) , customers.get(i));
        }
    }
    private void testEquals(Customer actual, Customer expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(actual.getPhone()).isEqualTo(expected.getPhone());
    }
}

