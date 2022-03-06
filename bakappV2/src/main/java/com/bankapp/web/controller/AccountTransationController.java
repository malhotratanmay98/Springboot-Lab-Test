package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bankapp.model.dto.DepositDto;
import com.bankapp.model.dto.TransferDto;
import com.bankapp.model.dto.WithdrawDto;
import com.bankapp.model.service.AccountService;

@Controller
@RequestMapping(path = "transaction")
public class AccountTransationController {

	private AccountService accountService;

	@Autowired
	public AccountTransationController(AccountService accountService) {
		this.accountService = accountService;
	}

	//-------------transfer---------------
	@GetMapping(path = "transfer")
	public ModelAndView transferGet(ModelAndView mv) {
		mv.setViewName("transfer");
		mv.addObject("transferDto", new TransferDto());
		return mv;
	}
	@PostMapping(path = "transfer")
	public String transferPost(@ModelAttribute TransferDto transferDto, RedirectAttributes attributes) {
		accountService.transfer(transferDto.getFromAccountId(),
				transferDto.getToAccountId(), transferDto.getAmount());
		attributes.addFlashAttribute("message", 
				"fund is transfered from acc "+ transferDto.getFromAccountId()+" to "+
		transferDto.getToAccountId()+" successfully!");
		return "redirect:success";
	}
	
	//-------withdraw-------
	
	@GetMapping(path = "withdraw")
	public ModelAndView withdrawGet(ModelAndView mv) {
		mv.setViewName("withdraw");
		mv.addObject("withdrawDto", new WithdrawDto());
		return mv;
	}
	@PostMapping(path = "withdraw")
	public String withdrawPost(@ModelAttribute WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccountId(), withdrawDto.getAmount());
		return "redirect:success";
	}
	
	//-------deposit-------
	
	@GetMapping(path = "deposit")
	public ModelAndView depositGet(ModelAndView mv) {
		mv.setViewName("deposit");
		mv.addObject("depositDto", new DepositDto());
		return mv;
	}
	@PostMapping(path = "deposit")
	public String depositPost(@ModelAttribute DepositDto depositDto) {
		accountService.deposit(depositDto.getAccountId(), depositDto.getAmount());
		return "redirect:success";
	}
	
	
	
	
	@GetMapping(path = "success")
	public String transferGet() {
		return "success";
	}
	
}




