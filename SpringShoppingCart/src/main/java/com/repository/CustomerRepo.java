package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.CustomerMaster;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerMaster ,Integer> {

}
