package com.valuelabs.dao;

import java.util.List;
import com.valuelabs.bean.AccountTransactionDetailsBean;

public interface FundsTransferDao {
	public boolean trnsferFunds(Double amount, String accountDetails);

	public boolean trnsferFundsUpdate(Double amount, String accountNumber);

	public List balanceAmountAfterTransferFunds(String accountDetails);

	boolean transferFundsToTransactionHistory(AccountTransactionDetailsBean accountTransactionDetailsBean);

	public List totalAmountAfterTransferFunds(String accountNumber);

	boolean updatedTransferFundsToTransactionHistory(AccountTransactionDetailsBean accountTransactionDetailsBean);

	public List checkAmount(String accountDetails);

}
