package com.db.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.db.demo.aspect.Registration;
@Service
public interface BankDAO extends JpaRepository<Registration,Integer> {
	@Query("select case when password=?2 and accno=?1 then true else false end from Registration where accno=?1")
	public boolean login(String accno,String password);
	
	@Query("from Registration where accno=?1")
	public List<Registration> findByAccno(String accno);

}
