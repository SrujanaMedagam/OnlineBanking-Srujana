package com.valuelabs.dao;

import java.util.List;
import com.valuelabs.bean.AccountDetailsBean;
import com.valuelabs.bean.LoginDetailsBean;

public interface LoginDao {
	public List checkLoginCredentials(String username,String password);
	public boolean newUserPermissionInfo( LoginDetailsBean newUserPermissionBean, AccountDetailsBean accountDetailsBean);
	public List checkIsAccountNumber(String accountNumber);
	public List checkIsUsername( String username);
	public List getAccountNumber( String username, String password);
	public List getProfile( String accountNumber);
	 public boolean profileUpdate( String accountNumber, String address, String emailId, int phoneNumber,
			String panNumber, int aadharNumber);

	
	
	
}
