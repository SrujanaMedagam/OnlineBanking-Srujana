package com.valuelabs.dao;

import java.util.List;

public interface TransactionHistoryDao {
	public List transactionHistory(String accountDetails);

	List transactionHistory(String accountDetails, String startDate, String endDate);

}
