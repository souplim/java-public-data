package com.mvc.user.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.mvc.user.vo.UserVO;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	private static Map<String, HttpSession> sessions = new ConcurrentHashMap<>();;
	
	//세션 생성시에 작동하는 리스너 메소드 (추후에 비로그인 유저 파악이 필요할때 사용 가능)
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		sessions.put(se.getSession().getId(), se.getSession());
	}
	
	//세션이 제거되었을때 작동하는 리스너 메소드 (로그아웃시 세션을 파기하게 되면 Map에서 해당 데이터 제거)
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		UserVO loginfo = (UserVO)se.getSession().getAttribute("loginfo");
		if(loginfo!=null) {
			sessions.remove(loginfo.getU_id());
		}else {
			sessions.remove(se.getSession().getId());
		}
	}
	
	//세션의 속성이 추가되었을때 작동하는 리스너 메소드 (로그인시에 세션에 loginfo가 추가되면서 Map에 해당 데이터 삽입)
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		UserVO loginfo = (UserVO)se.getSession().getAttribute("loginfo");
		if(loginfo!=null) {
			sessions.remove(se.getSession().getId());
			sessions.put(loginfo.getU_id(), se.getSession());
		}
	}
	
	//접속 여부 체크하는 메소드
	public static boolean isConnected(String u_id) {
		boolean result = false;
		for(String key : sessions.keySet()) {
			HttpSession session = sessions.get(key);
			if(session!=null&&session.getAttribute("loginfo")!=null) {
				UserVO loginfo = (UserVO)session.getAttribute("loginfo");
				if(loginfo.getU_id().equals(u_id)) result = true;
			}
		}
		return result;
	}
	
	//총 접속자 수를 체크하는 메소드
	public static int getCount() {
		return sessions.size();
	}
	
	//로그인한 회원 수를 체크하는 메소드
	public static int getLoginCount() {
		int count=0;
		for(String key : sessions.keySet()) {
			HttpSession session = sessions.get(key);
			if(session!=null&&session.getAttribute("loginfo")!=null) {
				count++;
			}
		}
		return count;
	}
	
	//비로그인 접속자 수를 체크하는 메소드
	public static int getNormalCount() {
		int count=0;
		for(String key : sessions.keySet()) {
			HttpSession session = sessions.get(key);
			if(session!=null&&session.getAttribute("loginfo")==null) {
				count++;
			}
		}
		return count;
	}

}
