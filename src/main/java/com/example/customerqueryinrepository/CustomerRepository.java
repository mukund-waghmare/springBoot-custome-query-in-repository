package com.example.customerqueryinrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.name=?1")
	Customer getByName(String name);

	@Query("SELECT u FROM Customer u where u.name=:name")
	Customer getcustByN(String name);

	@Query("Select u from Customer u where u.name=myPhone")
	Customer getname(@Param("myPhone") long phone);

}
