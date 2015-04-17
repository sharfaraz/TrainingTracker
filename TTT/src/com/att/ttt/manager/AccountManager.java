package com.att.ttt.manager;

import com.att.ttt.entity.Account;

public interface AccountManager {
	
	Account fetchAccount(String accountName);

}
