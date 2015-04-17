package com.att.ttt.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.att.ttt.dao.AccountDao;
import com.att.ttt.entity.Account;
import com.att.ttt.manager.AccountManager;

public class AccountManagerImpl implements AccountManager {
	
	private AccountDao accountDao;	

	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account fetchAccount(String accountName) {
		Account acc = new Account();
		acc = accountDao.getAccount(accountName);
		return acc;	
	}

}
