package com.example.repository;

import com.example.cdi.EntityManagerProducer;
import com.example.model.Customer;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.enterprise.context.Dependent;

/**
 * Created by ajohnson on 1/22/15.
 */
@Repository
//@EntityManagerConfig(entityManagerResolver = EntityManagerProducer.class)
//@Dependent
public interface CustomerRepository extends EntityRepository<Customer, Long> {
}
