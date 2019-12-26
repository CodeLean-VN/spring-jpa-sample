package com.codelean.repository;

import com.codelean.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        String query = "select c from Customer c";
        TypedQuery<Customer> customerTypedQuery = entityManager.createQuery(query, Customer.class);
        return customerTypedQuery.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            //update
            entityManager.merge(customer);
        }else {
            //add new
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(Long id, Customer model) {

    }
}
