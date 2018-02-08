package com.valuelabs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.valuelabs.bean.AccountTransactionDetailsBean;
import com.valuelabs.model.AccountTransactionDetails;

@Repository
@Transactional
public class DepositAndWithdrawDaoImpl implements DepositAndWithdrawDao {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;
	@Autowired(required = true)
	AccountTransactionDetails accountTransactionDetails;

	@Override
	public List depositAccNumber(String accountNumber) {
		String hql = "select acc.AccNumber from AccountDetails acc where acc.AccNumber= ?";
		List list = hibernateTemplate.find(hql, accountNumber);
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public boolean depositAccNumber(Double amount, String accountNumber) {
		String hql = "UPDATE AccountDetails set totalAmount = totalAmount + ? WHERE AccNumber=?";
		int result = hibernateTemplate.bulkUpdate(hql, amount, accountNumber);
		return true;
	}

	@Override
	public boolean withdrawAccNumber(String accountNumber, Double amount) {
		String hql = "UPDATE AccountDetails set totalAmount = totalAmount - ? WHERE AccNumber=?";
		int result = hibernateTemplate.bulkUpdate(hql, amount, accountNumber);
		return true;
	}

	@Override
	public List isAmountAvailable(String accountNumber) {
		String hql = "select acc.totalAmount from AccountDetails acc where acc.AccNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public List withdrawAccNumber(String accountNumber) {
		String hql = "select acc.AccNumber from AccountDetails acc where acc.AccNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public boolean depostAndWithdrawAmountToTransactionHistory(
			AccountTransactionDetailsBean accountTransactionDetailsBean) {
		accountTransactionDetails.setAccountNumber(accountTransactionDetailsBean.getAccountNumber());
		accountTransactionDetails.setTransactionDate(accountTransactionDetailsBean.getTransactionDate());
		accountTransactionDetails.setAmount(accountTransactionDetailsBean.getAmount());
		accountTransactionDetails.setTransactionType(accountTransactionDetailsBean.getTransactionType());
		accountTransactionDetails.setBalanceAmount(accountTransactionDetailsBean.getBalanceAmount());
		accountTransactionDetails.setRemarks(accountTransactionDetailsBean.getRemarks());
		hibernateTemplate.save(accountTransactionDetails);
		return true;
	}

	@Override
	public List balanceAmountAfterDeposit(String accountNumber) {
		String hql = " select acc.totalAmount from AccountDetails acc where acc.AccNumber= ? ";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public List balanceAmountAfterWithdraw(String accountNumber) {
		String hql = "select acc.totalAmount from AccountDetails acc where acc.AccNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

}
