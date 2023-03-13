package com.spring.admin.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.admin.login.dao.AdminLoginDao;
import com.spring.admin.login.vo.AdminLoginVO;

import lombok.Setter;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Setter(onMethod_ = @Autowired)
	private AdminLoginDao adminLoginDao;

	@Override
	public AdminLoginVO loginProcess(AdminLoginVO login) {
		AdminLoginVO lvo = adminLoginDao.loginProcess(login); 
		return lvo;
	}
	
	
}
