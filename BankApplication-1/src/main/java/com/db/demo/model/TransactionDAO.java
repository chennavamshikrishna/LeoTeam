package com.db.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionDAO extends JpaRepository<Transaction,Integer>{

	@Query("from Transaction t where t.acc1no=?1 or t.acc2no=?2")
	public List<Transaction> findByAccno(int acc1no,int acc2no);


	
	
	

}
