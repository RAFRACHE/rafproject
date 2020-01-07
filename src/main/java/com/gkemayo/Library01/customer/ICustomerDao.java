package com.gkemayo.Library01.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerDao extends JpaRepository<Customer, Integer> {
    //recherche des utilisateur par leurs email
    public Customer findCustomerByEmailIgnoreCase(String mail);
    //recherche des utilisateur par le prenom
    public List<Customer> findCustomerByLastNameIgnoreCase(String lastName);
}