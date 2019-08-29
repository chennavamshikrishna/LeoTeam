package com.db.demo.aspect;

import java.io.IOException;

import javax.mail.MessagingException;

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
import com.db.demo.model.Transaction;

import Utils.AccountGenerator;

@Component
@Aspect
public class RegisterServiceAspect {
	
	@Autowired 
	AccountsDAO accdao;
	@Autowired
	Accounts acc;
	
	@After(value="execution(* com.db.demo.RegisterService.createCustomer(..)) and args(reg)")
	public void afterAdvice(JoinPoint joinpoint, Registration reg) {
	/*	try {
			AccountGenerator.sendmail();
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		acc.setAccno(reg.getAccno());
		acc.setAmount(0);
		accdao.save(acc);
	   
		System.out.println("after method:"+reg.getAccno());
	}
	@After(value="execution(* com.db.demo.RegisterService.createTransaction(..)) and args(tra)")
    public void afterTransactionAdvice(JoinPoint joinpoint,Transaction tra) {
		if(tra.getTtype()==1) {
			System.out.println("after method:"+tra.getAmount()+""+tra.getAcc1no()+"   "+tra.getAcc2no());

			accdao.creditAmount(tra.getAmount(),tra.getAcc1no());
			accdao.debitAmount(tra.getAmount(),tra.getAcc2no());
		}
		else {
			accdao.creditAmount(tra.getAmount(),tra.getAcc2no());
			accdao.debitAmount(tra.getAmount(),tra.getAcc1no());
		}
	}
}
