package com.db.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.db.demo.aspect.Registration;
import com.db.demo.model.BankDAO;
import com.db.demo.model.Transaction;
import com.db.demo.model.TransactionDAO;

@Service
public class RegisterService {
	
	@Autowired
	BankDAO regdao;
	
	@Autowired
	TransactionDAO tradao;
	public Registration createCustomer(@RequestBody Registration reg) {
		return regdao.save(reg);
	}
	
	public Transaction createTransaction(@RequestBody Transaction tra) {
		return tradao.save(tra);
	}

}
