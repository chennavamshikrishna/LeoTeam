package com.db.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionDAO extends JpaRepository<Transaction,Integer>{

	@Query("from Transaction t where t.acc1no=?1")
	public List<Transaction> findByAccno1(String acc1no);

	@Query("from Transaction t where t.acc2no=?1")
	public List<Transaction> findByAccno2(String acc2no);
	
	
	

}
