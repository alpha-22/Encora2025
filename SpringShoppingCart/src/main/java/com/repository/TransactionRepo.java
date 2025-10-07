package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.BillTransaction;
import com.model.CompKey;

@Repository
public interface TransactionRepo extends JpaRepository<BillTransaction, CompKey> {

}
