package com.db.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsDAO extends JpaRepository<Accounts,Integer> {

}
