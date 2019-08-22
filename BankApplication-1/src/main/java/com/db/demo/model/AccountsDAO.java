package com.db.demo.model;

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

}
