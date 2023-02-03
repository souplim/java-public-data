package com.mvc.user.service;

import java.util.ArrayList;

import com.mvc.user.dao.UserDAO;
import com.mvc.user.vo.UserVO;

public class UserService {
	private static UserService service = null;
	private UserDAO dao = UserDAO.getInstance();
	
	private UserService() {}
	public static UserService getInstance() {
		if(service == null)
			service = new UserService();
		return service;
	}
	
	public ArrayList<UserVO> userList(){
		ArrayList<UserVO> list = dao.userList();
		return list;
	}
	
	public UserVO logInfoCheck(String u_id, String u_pw) {
		UserVO data = dao.logInfoCheck(u_id, u_pw);
		return data;
	}
	
	public boolean userInsert(UserVO vo) {
      boolean result = dao.userInsert(vo);
      return result;
    }
	
	public int userIdChk(String u_id) {
		int result = dao.userIdChk(u_id);
	    return result;
	}
	
	public UserVO userDetail(String u_id) {
		UserVO data = dao.userDetail(u_id);
		return data;
	}
	
	public int userPasswdChk(String u_id, String u_pw) {
		int result = dao.userPassChk(u_id, u_pw);
		return result;
	}
	
	public UserVO updateForm(String u_id) {
		UserVO data = dao.userDetail(u_id);
		return data;
	}
	
	public boolean userUpdate(UserVO vo) {
		boolean result = dao.userUpdate(vo);
		return result;
	}
	public boolean UserDelete(String u_id) {
		boolean result = dao.userDelete(u_id);
		return result;
	}

}
