package com.valuelabs.controller;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.valuelabs.service.LoginService;
import com.valuelabs.service.TransactionHistoryService;

@Controller
@RequestMapping("/history")
public class TransactionHistoryController {
	@Autowired(required = true)
	TransactionHistoryService transactionHistoryService;

	@Autowired(required = true)
	LoginService loginService;

	@RequestMapping("/transactonHistory")
	public @ResponseBody String depositAmount(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String accountDetails = "";
		String result;
		List list = loginService.checkUserAccountNumber(username, password);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			accountDetails = (String) it.next();
		}
		List list1 = transactionHistoryService.transactionHistory(accountDetails);
		if (list1.isEmpty()) {
			result = "failed";
		} else {
			result = "passed";
		}
		return result;
	}

	@RequestMapping("/showhistory")
	public @ResponseBody List showDetails(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String accountDetails = "";
		List list = loginService.checkUserAccountNumber(username, password);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			accountDetails = (String) it.next();
		}
		List transactionHistory = transactionHistoryService.transactionHistory(accountDetails);
		return transactionHistory;
	}
}
