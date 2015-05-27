package com.asiantech.spring.service;
import java.util.List;

import com.asiantech.spring.etity.Account;

public interface AccountService {
	public final String NAME = "accountService";
	 public void addAccount(Account account);
    public List<Account> listAccount();
    public void removeAccount(int id);
}
