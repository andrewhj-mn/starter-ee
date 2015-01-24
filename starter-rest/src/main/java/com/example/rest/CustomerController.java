package com.example.rest;

import com.example.model.Customer;
import com.example.service.CustomerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Stateless
@Path("/customer")
public class CustomerController {
    @EJB
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findById(@PathParam("id") Long id) {
        return customerService.findOne(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        final Customer serviceResponse = customerService.createCustomer(customer);
        if (serviceResponse != null) {
            final URI uri = URI.create(serviceResponse.getId().toString());
            return Response.created(uri).build();
        } else {
            return Response.notModified().build();
        }
    }
}

