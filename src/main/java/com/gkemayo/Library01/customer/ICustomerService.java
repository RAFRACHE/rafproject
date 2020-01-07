package com.gkemayo.Library01.customer;
import java.util.List;

import org.springframework.data.domain.Page;

public interface ICustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Integer customerId);

    public boolean checkIfIdexists(Integer id);

    public Customer findCustomerByEmail(String email);

    public List<Customer> findCustomerByLastName(String lastName);

    public Customer findCustomerById(Integer customerId);

    public Page<Customer> getPaginatedCustomersList(int begin, int end);

}
