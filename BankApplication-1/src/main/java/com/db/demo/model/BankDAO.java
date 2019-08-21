package com.db.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.db.demo.aspect.Registration;
@Service
public interface BankDAO extends JpaRepository<Registration,Integer> {

}
