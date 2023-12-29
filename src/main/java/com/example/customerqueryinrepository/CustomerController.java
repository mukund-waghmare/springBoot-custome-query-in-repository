package com.example.customerqueryinrepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	

//	@GetMapping("/byname")
//	public ResponseEntity<ResponseStructure<Customer>> getCustomerByName(@PathVariable String name)
//	{
//
//		System.out.println("---------------------------------");
//		
//		Customer customer=repository.getCustomerByName(name);
//		ResponseStructure<Customer> resp= new ResponseStructure<>();
//		System.out.println("---------------------------------");
//		if(customer!=null)
//		{
//              resp.setStatus(HttpStatus.ACCEPTED.value());
//              resp.setMessage(customer.getName());
//              resp.setData(customer);
//        }
//		else
//		{
//			resp.setStatus(HttpStatus.BAD_REQUEST.value());
//            resp.setMessage("Name Not Found");
//            resp.setData(null);
//            
//		}
//		return  new ResponseEntity<ResponseStructure<Customer>>(resp,HttpStatus.ACCEPTED);
//		
//	}
	
	
	@GetMapping("/save")
	public Customer save(@RequestBody Customer cust)
	{
		repository.save(cust);
		
		return cust;
	}
	
	@GetMapping("/getByName/{name}")
	public Customer getByName(@PathVariable String name)
	{
		Customer customer=repository.getByName(name);
		
		return customer;
	}
	
	@PostMapping("/byId/{id}")
	public Optional<Customer> byId(@PathVariable int id)
	{
		Optional<Customer> customer=repository.findById(id);
		
		return customer;
		
	}
	
}
