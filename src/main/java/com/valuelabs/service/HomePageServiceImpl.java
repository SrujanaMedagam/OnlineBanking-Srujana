package com.valuelabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.valuelabs.dao.HomePageDao;
import com.valuelabs.dao.LoginDao;

@Service("homePageService")
public class HomePageServiceImpl implements HomePageService {

	@Autowired(required = true)
	LoginDao loginDao;
	@Autowired(required = true)
	HomePageDao homePageDao;

	@Override
	public List checkUserLoginCredentials(String username, String password) {
		List list = loginDao.checkLoginCredentials(username, password);
		return list;
	}

	@Override
	public List checkAccountDetails(String accountDetails) {
		List list1 = null;
		list1 = homePageDao.accountDetailsInfo(accountDetails);
		return list1;
	}

}
