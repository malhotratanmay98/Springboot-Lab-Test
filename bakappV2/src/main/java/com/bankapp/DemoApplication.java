package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.model.dao.account.Account;
import com.bankapp.model.dao.user.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.UserService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

//	@Autowired
//	private AccountService accountService;
//	
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		userService.addUser(new User("raj", "raj121", "ROLE_MGR", "raj@gmail.com"));
//		userService.addUser(new User("gun", "gun121", "ROLE_CLERK", "gun@gmail.com"));
//		
//		accountService.addAccount(new Account( "ravi", 3000.00, "5565756656", 
//				"krishna nagar delhi", "ravi@gmail.com"));
//		
//		accountService.addAccount(new Account( "geeta", 3000.00, "5569756656", 
//				"laxmi nagar delhi", "geeta@gmail.com"));
//		
	}

}
