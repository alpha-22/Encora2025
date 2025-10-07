package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.BillMaster;

public interface BillRepo extends JpaRepository<BillMaster, Integer> {

}
