package com.spring.admin.login.dao;

import com.spring.admin.login.vo.AdminLoginVO;

public interface AdminLoginDao {
	public AdminLoginVO loginProcess(AdminLoginVO login); // 일치했을 때 admin 데이터 반환 
}
