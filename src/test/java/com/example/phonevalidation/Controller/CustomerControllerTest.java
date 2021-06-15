package com.example.phonevalidation.Controller;

import com.example.phonevalidation.model.CustomerModel;
import com.example.phonevalidation.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
public class CustomerControllerTest {
    private static final String allCustomers = "/phones";
    @Autowired
    private CustomerService customerService;
    private MockMvc mockMvc;
    @Test
    void getAllPhones()throws Exception
    {
//        //List<CustomerModel> customerModelList = new ArrayList<>();
//        when(customerService.getAllPhoneNumbers()).thenReturn("yes");
//        System.out.println("---"+mockMvc.perform(get(allCustomers)));
//        mockMvc.perform(get(allCustomers).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$[*].id").isNotEmpty()).andExpect(jsonPath("$[*].name").isNotEmpty()).andExpect(jsonPath("$[*].phone").isNotEmpty());
   }

}
