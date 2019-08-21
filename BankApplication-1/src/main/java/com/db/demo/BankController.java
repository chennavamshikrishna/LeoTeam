package com.db.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.demo.aspect.Registration;
import com.db.demo.model.Accounts;
import com.db.demo.model.AccountsDAO;

@RestController
@RequestMapping(value="/web")
public class BankController {
	
	@Autowired
	RegisterService rserv;
	
	@Autowired
	AccountsDAO accdao;
	
/*	@GetMapping("/data")
	public List<Registration> getCustomers(){
		
		return dao.findAll();

}*/
	@GetMapping(value="hi")
	public String hello() {
		return "hello";
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
	
}
