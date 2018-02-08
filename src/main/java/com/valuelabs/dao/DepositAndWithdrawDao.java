package com.valuelabs.dao;

import java.util.List;

import com.valuelabs.bean.AccountTransactionDetailsBean;

public interface DepositAndWithdrawDao {
	public boolean depositAccNumber(Double amount, String accountNumber);

	public List depositAccNumber(String accountNumber);

	public List withdrawAccNumber(String accountNumber);

	public boolean withdrawAccNumber(String accountNumber, Double amount);

	public boolean depostAndWithdrawAmountToTransactionHistory(AccountTransactionDetailsBean accountTransactionDetailsBean);

	public List balanceAmountAfterDeposit(String accountNumber);

	public List balanceAmountAfterWithdraw(String accountNumber);

	public List isAmountAvailable(String accountNumber);

}
