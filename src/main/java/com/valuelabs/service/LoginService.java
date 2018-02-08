package com.valuelabs.service;

import java.util.List;

public interface LoginService {
	boolean checkUserLoginCredentials(String username, String password);

	public List checkUserAccountNumber(String username, String password);

	public boolean newUserPermission(String accountNumber, String accountName, String username, String password,
			String address, String emailId, int phoneNumber, String panNumber, int aadharNumber, String accountType,
			String date);

	boolean checkIsAccountNumber(String accountNumber);

	public boolean checkUserId(String username);

	public List checkIsValidAccountNumber(String accountNumber);

	public String getAccountNumber(String username, String password);

	public boolean isAccountNumber(String username, String password);

	public List getProfileData(String accountNumber);

	public boolean getProfileUpdate(String accountNumber, String address, String emailId, int phoneNumber,
			String panNumber, int aadharNumber);

}
