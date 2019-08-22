package com.db.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAO extends JpaRepository<Transaction,Integer>{
	
	
	

}
