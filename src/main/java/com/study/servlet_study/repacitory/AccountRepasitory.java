package com.study.servlet_study.repacitory;

import java.util.ArrayList;
import java.util.List;
import com.study.servlet_study.entitiy.Account;

public class AccountRepasitory {
	private static AccountRepasitory instance;
	private List<Account> accountList;

	private AccountRepasitory( ) {
	accountList = new ArrayList<>();
	}

		public static AccountRepasitory getInstance() {
			if(instance == null) {
				instance = new AccountRepasitory();
			}
				return instance;
			}
		
		public int saveAccount(Account account) {
			
			accountList.add(account);
			return 1;
			
		}
		public Account findAccountByUsername(String username) {
			Account findAccount = null;
			for(Account account : accountList) {
				if(account.getUsername().equals(username)) {
					findAccount = account;
					break;
				}
				
			}
			
			return findAccount;
			
			
		}
		
		
		
		
	
}
