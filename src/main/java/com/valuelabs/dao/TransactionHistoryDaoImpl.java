package com.valuelabs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TransactionHistoryDaoImpl implements TransactionHistoryDao {
	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	@Override
	public List transactionHistory(String accountDetails) {
		String hql = "from AccountTransactionDetails acc where acc.accountNumber=? Order By transactionDate DESC";
		return (List<String>) hibernateTemplate.find(hql, accountDetails);

	}
	@Override
	public List transactionHistory(String accountDetails,String startDate, String endDate) {
		String hql = "from AccountTransactionDetails acc where acc.transactionDate BETWEEN ? AND ?";
		//select * from srujana.AccountTransactionDetails acc where acc.transactionDate BETWEEN 2017-03-10 AND 2017-03-09;
		System.out.println("$$$$");
		return (List<String>) hibernateTemplate.find(hql,startDate,endDate);

	}

}
