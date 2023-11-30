package com.exercice.cms.service;

import com.exercice.cms.dao.CustomerDAO;
import com.exercice.cms.exception.CustomerNotFoundException;
import com.exercice.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class CustomerService {
    private CustomerDAO customerDAO;
    private int customerIdCount=1;
    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    private List<Customer> customerList=new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {

//        customer.setCustomerId(customerIdCount);
//
//        customerList.add(customer);
//
//        customerIdCount++;
        return customerDAO.save(customer);

//        return customer;
    }
    public List<Customer> getCustomers() {
       return   customerDAO.findAll();

//        return customerList;
    }
public  Customer getCustomer(int customerId){
    Optional<Customer> optionalCustomer= customerDAO.findById(customerId);
    if(!optionalCustomer.isPresent()){
        System.out.println("iciiii not found customer");
        throw new CustomerNotFoundException("Customer Record is not available...");
    }
    return optionalCustomer.get();
}
public Customer upddateCustomer(int customerId,Customer customer){
    customer.setCustomerId(customerId);
//        customerList.stream().forEach(c -> {
//            if (c.getCustomerId() == customerId) {
//                c.setCustomerFirstName(customer.getCustomerFirstName());
//                c.setCustomerLasttName(customer.getCustomerLasttName());
//                c.setCustomerEmail(customer.getCustomerEmail());
//            }
//
//        });
//        return customerList.stream().filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();
    return  customerDAO.save(customer);
}
public void deleteCustomer(int customerId){
//        customerList.stream().forEach(c ->{
//            if(c.getCustomerId()== customerId){
//                customerList.remove(c);
//            }
//        });
customerDAO.deleteById(customerId);
    }
}
