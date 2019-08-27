package com.db.demo;

import java.util.List;

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
	
	@GetMapping("/register")
	public List<Registration> getCustomers(){
		
		return dao.findAll();

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
	public String depositAmount(@RequestBody Accounts as) {
		accdao.setDepositAmount(as.getAmount(), as.getAccno());
		
		
		return "success";
	}
	@PostMapping("/transaction")
   public String transaction(@RequestBody Transaction ts) {
		rserv.createTransaction(ts);
		return "success";
	}
	@PostMapping("/ministatement")
	public List<Transaction> getMinistatement(@RequestBody Transaction ts) {
		
		return trdao.findByAccno(ts.getAcc1no(), ts.getAcc1no());
	}
	@PostMapping("/checkbalance")
	public boolean getBalance(@RequestBody Accounts as) {
		return accdao.balanceByAccno(as.getAccno(),as.getAmount());
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody Registration reg) {
		return dao.login(reg.getAccno(), reg.getPassword());
	}
	
}
