package com.bankapp.model.dto;

import com.bankapp.model.dao.account.Account;

public class DtoUtil {
	public static Account convertToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setName(accountDto.getName());
		account.setAddress(accountDto.getAddress());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setPhoneNumber(accountDto.getPhoneNumber());
		
		return account;
	}
}
