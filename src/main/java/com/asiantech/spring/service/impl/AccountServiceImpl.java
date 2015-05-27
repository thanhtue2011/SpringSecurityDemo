package com.asiantech.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asiantech.spring.dao.AccountDao;
import com.asiantech.spring.etity.Account;
import com.asiantech.spring.service.AccountService;
@Repository(AccountService.NAME)
@Service
public class AccountServiceImpl implements AccountService {

	    @Autowired
	    private AccountDao accountdao;
	     
	    @Transactional
	    public void addAccount(Account account) {
	       
	    }
	 
	    @Transactional
	    public List<Account> listAccount() {
	 
	        return accountdao.listAccount();
	    }
	 
	    @Transactional
	    public void removeAccount(int id) {
	        accountdao.removeAccount(id);
	    }

}
