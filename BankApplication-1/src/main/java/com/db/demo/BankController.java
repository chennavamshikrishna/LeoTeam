package com.db.demo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.demo.aspect.Registration;
import com.db.demo.model.Accounts;
import com.db.demo.model.AccountsDAO;
import com.db.demo.model.BankDAO;
import com.db.demo.model.Transaction;
import com.db.demo.model.TransactionDAO;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/web")
public class BankController {
	
	@Autowired
	RegisterService rserv;
	
	@Autowired
	AccountsDAO accdao;
	
	@Autowired
	TransactionDAO trdao;
	
	@Autowired
	BankDAO dao;
	
	@PostMapping("/profile")
	public List<Registration> getProfile(@RequestBody Registration reg){
		return dao.findByAccno(reg.getAccno());
	}
	
	@PostMapping("/register")
	public String insertCustomer(@RequestBody Registration reg) {
		 
		
		   
		
		rserv.createCustomer(reg);
		
		return "success";
	}
	@PostMapping("/accounts")
	public String insertAccounts(@RequestBody Accounts as)
{
	accdao.save(as);
	return "success";
}
	@PostMapping("/deposit")
	public Map depositAmount(@RequestBody Accounts as) {
		accdao.setDepositAmount(as.getAmount(), as.getAccno());
		
		 return Collections.singletonMap("response", "success");
		
	}
	@PostMapping("/transaction")
   public Map transaction(@RequestBody Transaction ts) {
		rserv.createTransaction(ts);
		 return Collections.singletonMap("response", "success");
	}
	@PostMapping("/creditstatement")
	public List<Transaction> getCreditMinistatement(@RequestBody Transaction ts) {
		
		return trdao.findByAccno1(ts.getAcc1no());
	}
	@PostMapping("/debitstatement")
	public List<Transaction> getDebitMinistatement(@RequestBody Transaction ts) {
		
		return trdao.findByAccno2(ts.getAcc2no());
	}
	@PostMapping("/checkbalance")
	public boolean getBalance(@RequestBody Accounts as) {
		return accdao.balanceByAccno(as.getAccno(),as.getAmount());
	}
	@PostMapping("/minimumbalance")
	public List<Accounts> getMinimumBalance(@RequestBody Accounts as){
		return accdao.checkBalance(as.getAccno());
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Registration reg) {
		return dao.login(reg.getAccno(), reg.getPassword());
	}
	
}
