package com.valuelabs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.LoginDetailsBean;
import com.valuelabs.model.AccountDetails;
import com.valuelabs.model.LoginDetails;

@Transactional
@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	@Autowired(required = true)
	AccountDetails accountDetails; 
	
	@Autowired(required = true)
	LoginDetails loginDetails;

	@SuppressWarnings("unchecked")
	@Override
	public List checkLoginCredentials(String username, String password) {
		String hql = "Select user.accountNumber from LoginDetails user where user.username=? and user.password=?";
		return (List) hibernateTemplate.find(hql, username, password);
	}

	@Override
	public boolean newUserPermissionInfo(LoginDetailsBean loginDetailsBean, AccountDetailsBean accountDetailsBean) {
		loginDetails.setAccountNumber(loginDetailsBean.getAccountNumber());
		loginDetails.setAccountName(loginDetailsBean.getAccountName());
		loginDetails.setUsername(loginDetailsBean.getUsername());
		loginDetails.setPassword(loginDetailsBean.getPassword());
		loginDetails.setAddress(loginDetailsBean.getAddress());
		loginDetails.setEmailId(loginDetailsBean.getEmailId());
		loginDetails.setPhoneNumber(loginDetailsBean.getPhoneNumber());
		loginDetails.setPanNumber(loginDetailsBean.getPanNumber());
		loginDetails.setAadharNumber(loginDetailsBean.getAadharNumber());
		loginDetails.setAccountType(loginDetailsBean.getAccountType());
		loginDetails.setAccountOpenDate(loginDetailsBean.getAccountOpenDate());
		accountDetails.setAccNumber(accountDetailsBean.getAccNumber());
		accountDetails.setAccName(accountDetailsBean.getAccName());
		accountDetails.setStatusOfAccount("Active");
		accountDetails.setAccountType(accountDetailsBean.getAccountType());
		accountDetails.setAccountOpenDate(accountDetailsBean.getAccountOpenDate());
		hibernateTemplate.save(loginDetails);
		hibernateTemplate.save(accountDetails);

		return true;
	}

	@Override
	public List checkIsAccountNumber(String accountNumber) {

		String hql = "Select user.accountNumber from LoginDetails user where user.accountNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public List checkIsUsername(String username) {
		String hql = "Select user.username from LoginDetails user where user.username=?";
		return (List<String>) hibernateTemplate.find(hql, username);
	}

	@Override
	public List getAccountNumber(String username, String password) {
		String hql = "Select user.accountNumber from LoginDetails user where user.username=? and user.password=?";
		return (List<String>) hibernateTemplate.find(hql, username, password);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getProfile(String accountNumber) {
		String hql = "from LoginDetails user where user.accountNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountNumber);
	}

	@Override
	public boolean profileUpdate(String accountNumber, String address, String emailId, int phoneNumber,
			String panNumber, int aadharNumber) {
		String hql = "UPDATE AccountDetails set address = :address and emailId =:emailId and phoneNumber = :phoneNumber and panNumber = :panNumber and aadharNumber = :aadharNumber WHERE AccNumber=:accountNumber";
		int result = hibernateTemplate.bulkUpdate(hql, accountNumber, address, emailId, phoneNumber, panNumber,
				aadharNumber);
		return true;
	}

}
