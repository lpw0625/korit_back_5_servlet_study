package com.study.servlet_study.service;

import com.study.servlet_study.entitiy.Account;
import com.study.servlet_study.repacitory.AccountRepasitory;

public class AccountService {
	private static AccountService instance;
	private AccountRepasitory accountRepasitory;
	
	private AccountService() {
		accountRepasitory = AccountRepasitory.getInstance();
			
	}

public static AccountService getInstance( ) {
	if(instance == null) {
		instance = new AccountService();
	}
	return instance; 
}

public int addAccount(Account account) {
return accountRepasitory.saveAccount(account);
}
		
public Account getAccount(String username) {
	return accountRepasitory.findAccountByUsername(username);
}

}
