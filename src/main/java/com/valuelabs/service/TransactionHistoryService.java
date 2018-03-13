package com.valuelabs.service;

import java.util.List;

public interface TransactionHistoryService {
	public List transactionHistory(String accountDetails);

	List transactionHistory(String accountDetails, String stsrtDate, String endDate);
}
