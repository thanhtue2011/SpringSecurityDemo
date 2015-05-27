package com.asiantech.spring.dao;

import java.util.List;

import com.asiantech.spring.etity.Account;

public interface AccountDao {
	    public void editAccount(Account account);
	    public List<Account> listAccount();
	    public List<Account> SearchlistAccount(String name);
	    public void removeAccount(int id);
	    public Account get(int id);
	    public List<Account>  getLimitAccount(int limit, int offset);
	    public int getNumber();
	    public int getAllTotal();
	    public int getAllTotalSearch(String name);
	    public List<Account>  getLimitAccountSearch(int limit, int offset,String name);
	    public List<Account> getPage(int page);

}
