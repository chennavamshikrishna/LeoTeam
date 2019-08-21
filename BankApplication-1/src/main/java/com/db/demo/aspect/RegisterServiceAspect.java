package com.db.demo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.db.demo.model.Accounts;
import com.db.demo.model.AccountsDAO;

@Component
@Aspect
public class RegisterServiceAspect {
	
	@Autowired 
	AccountsDAO accdao;
	@Autowired
	Accounts acc;
	
	@After(value="execution(* com.db.demo.RegisterService.createCustomer(..)) and args(reg)")
	public void afterAdvice(JoinPoint joinpoint, Registration reg) {
		acc.setAccno(reg.getAccno());
		acc.setAmount(0);
		accdao.save(acc);
	   
		System.out.println("after method:"+reg.getAccno());
	}

}
