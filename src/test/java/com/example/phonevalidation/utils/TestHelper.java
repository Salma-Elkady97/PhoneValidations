package com.example.phonevalidation.utils;

import com.example.phonevalidation.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {
    public TestHelper(){}
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer Customer1 = new Customer();
        Customer1.setId(0);
        Customer1.setName("Walid Hammadi");
        Customer1.setPhone("(212) 6007989253");
        Customer Customer2 = new Customer();
        Customer2.setId(1);
        Customer2.setName("Yosaf Karrouch");
        Customer2.setPhone("(212) 698054317");
        Customer Customer3 = new Customer();
        Customer3.setId(2);
        Customer3.setName("Younes Boutikyad");
        Customer3.setPhone("(212) 6546545369");
        customers.add(Customer1);
        customers.add(Customer2);
        customers.add(Customer3);
        return customers;
    }
}
