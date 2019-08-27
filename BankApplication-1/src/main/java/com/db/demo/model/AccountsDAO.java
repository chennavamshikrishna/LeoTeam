package com.db.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountsDAO extends JpaRepository<Accounts,Integer> {
	@Transactional
	@Modifying
	@Query("update Accounts a set a.amount=?1 where a.accno=?2")
	public void setDepositAmount(int amount,int accno);
	
	@Transactional
	@Modifying
	@Query("update Accounts a set a.amount=a.amount+?1 where a.accno=?2")
    public void creditAmount(int amount,int accno);
	
	@Transactional
	@Modifying
	@Query("update Accounts a set a.amount=a.amount-?1 where a.accno=?2")
	public void debitAmount(int amount,int accno);
    
	
  
	//@Query("select accno from Accounts where accno=?1 and amount>?2")
	@Query("select case when amount>?2 then true else false end from Accounts where accno=?1 ")
	public boolean balanceByAccno(int accno, int amount);
	
	

}
