package com.valuelabs.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class HomePageDaoImpl implements HomePageDao {

	@Autowired(required = true)
	private HibernateTemplate hibernateTemplate;

	@Override
	public List accountDetailsInfo(String accountDetails) {
		String hql = " from AccountDetails acc where acc.AccNumber = ? ";
		List list = (List<String>) hibernateTemplate.find(hql, accountDetails);
		if (!list.isEmpty()) {
			return list;
		} else {
			return list;
		}
	}

	@Override
	public List accountDetails(String accountDetailslist) {
		String hql = " from AccountDetails where accNumber=?";
		return (List<String>) hibernateTemplate.find(hql, accountDetailslist);
	}

}
