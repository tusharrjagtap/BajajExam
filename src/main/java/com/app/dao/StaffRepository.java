package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	

	//Optional<Employee> findBySalaryGreaterThanValue(double value)
//update employees set join_date='2020-11-21',last_name='Kher',salary=53456 where id=6;

}
