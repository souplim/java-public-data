package com.mvc.user.dao;

import static com.mvc.common.util.JDBCTemplate.close;
import static com.mvc.common.util.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mvc.user.vo.UserVO;

public class UserDAO {
	private static UserDAO instance = null;
	public static UserDAO getInstance() {
		if(instance==null)
			instance = new UserDAO();
		return instance;
	}	
	
	/***********************************************************
	* userList() 메서드: 유저 전체목록 조회
	* @return ArrayList<UserVO> 리턴.
	***********************************************************/
	public ArrayList<UserVO> userList(){
        ArrayList<UserVO> list = new ArrayList<UserVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
    		StringBuffer query = new StringBuffer();
//    		query.append("select u_id, u_pw, u_st, u_name, u_email, u_phone, u_gender, ");
//    		query.append("to_char(u_regday, 'YYYY/MM/DD') u_regday ");
//    		query.append("from b_user order by u_regday");

    		// 보안 문제로 아이디 / 이름 / 전화번호 / 이메일 마스킹 / 등록일 조회
    		query.append("SELECT ");
    		query.append("REGEXP_REPLACE(u_id, ',', '*', 4) AS u_id, ");
    		query.append("REGEXP_REPLACE(u_name, '.', '*', 2, 1) AS u_name, ");
    		query.append("REGEXP_REPLACE(u_phone,'(\\d{3})\\-(\\d{3,4})\\-(\\d{4})','\\1-****-\\3') AS u_phone, ");
    		query.append("CONCAT('***',SUBSTR(u_email, 4, LENGTH(u_email))) AS u_email, ");
    		query.append("TO_CHAR(u_regday, 'yyyy-mm-dd hh24:mi:ss') u_regday ");
    		query.append("FROM b_user");
    		
    		
            pstmt = conn.prepareStatement(query.toString());
            rs = pstmt.executeQuery();

            while (rs.next()){
            	UserVO data = new UserVO();
            	
            	data.setU_id(rs.getString("u_id"));
            	data.setU_pw(rs.getString("u_pw"));
            	data.setU_st(rs.getInt("u_st"));
            	data.setU_name(rs.getString("u_name"));
            	data.setU_email(rs.getString("u_email"));
            	data.setU_phone(rs.getString("u_phone"));
            	data.setU_gender(rs.getString("u_gender"));
            	data.setU_regday(rs.getString("u_regday"));
            	
                list.add(data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
            close(conn);
        }
        return list;
	}
	
	
	/***********************************************************
	* logInfoCheck() 메서드: 로그인 요청받은 정보를 체크하여 존재하면 세션에 넣을 데이터를 반환.
	* @param 회원 아이디와 비밀번호
	* @return UserVO 리턴
	***********************************************************/
	public UserVO logInfoCheck(String u_id, String u_pw) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    	UserVO data = null;
    	
        try {
            conn = getConnection();
    		StringBuffer query = new StringBuffer();
    		query.append("select u_id, u_st, u_name ");
    		query.append("from b_user where u_id=? and u_pw=?");

            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, u_id);
            pstmt.setString(2, u_pw);
            rs = pstmt.executeQuery();

            while (rs.next()){
            	data = new UserVO();
            	data.setU_id(rs.getString("u_id"));
            	data.setU_st(rs.getInt("u_st"));
            	data.setU_name(rs.getString("u_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(rs);
            close(pstmt);
            close(conn);
        }
        return data;
	}
	
	/**********************************************************
	* userRegister() 메서드: 회원등록
	* @return boolean 리턴.
	***********************************************************/
	public boolean userInsert(UserVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO b_user(u_id, u_pw, u_st, u_name, u_email, u_phone, u_gender, u_regday) ");
			sql.append("VALUES(?, ?, 0, ?, ?, ?, ?, sysdate)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getU_id());
			pstmt.setString(2, vo.getU_pw());
			pstmt.setString(3, vo.getU_name());
			pstmt.setString(4, vo.getU_email());
			pstmt.setString(5, vo.getU_phone());
			pstmt.setString(6, vo.getU_gender());
			
			int insertCount = pstmt.executeUpdate();
			
			if(insertCount == 1) {
				success = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn); 
		}
		
		return success;
	}


	/**********************************************************
	* userIdChk() 메서드: 아이디 중복 확인 메서드
	* @param 아이디
	* @return int 리턴 (중복x : 0, 중복 : 1)
	***********************************************************/
	public int userIdChk(String u_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT u_id FROM b_user where u_id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();

			while(rs.next()) 
				id = rs.getString("u_id"); 
			
			if(id!=null) 
				result = 1; //  중복x : 0, 중복 : 1

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	/**********************************************************
	* userDetail() 메서드: 회원정보 상세 페이지 처리 메서드.
	* @param 아이디
	* @return UserVO 리턴
	***********************************************************/
	public UserVO userDetail(String u_id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO data = new UserVO();
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT u_id, u_pw, u_st, u_name, u_email, u_phone, u_gender, u_regday ");
			sql.append("FROM b_user where u_id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data.setU_id(rs.getString("u_id"));
            	data.setU_pw(rs.getString("u_pw"));
            	data.setU_st(rs.getInt("u_st"));
            	data.setU_name(rs.getString("u_name"));
            	data.setU_email(rs.getString("u_email"));
            	data.setU_phone(rs.getString("u_phone"));
            	data.setU_gender(rs.getString("u_gender"));
            	data.setU_regday(rs.getString("u_regday"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return data;
	}

	/**********************************************************
	* userPassChk() 메서드: 비밀번호 조회 메서드
	* @param 아이디, 비밀번호
	* @return int 리턴
	***********************************************************/
	public int userPassChk(String u_id, String u_pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT NVL((SELECT 1 FROM b_user WHERE u_id = ? ");
			sql.append("AND u_pw = ?), 0) AS result FROM dual");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) 
				result = rs.getInt("result"); // 비밀번호 일치: 1 / 비밀번호 불일치: 0 반환
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return result;
	}


	/**********************************************************
	* userUpdate() 메서드: 회원정보 수정 처리 메서드
	* @param UserVO
	* @return boolean
	***********************************************************/
	public boolean userUpdate(UserVO vo) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            
            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE b_user SET u_pw = ?, u_name = ?, u_email = ?, u_phone = ?, u_gender = ? WHERE u_id = ?");

            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, vo.getU_pw()); 
            pstmt.setString(2, vo.getU_name()); 
            pstmt.setString(3, vo.getU_email()); 
            pstmt.setString(4, vo.getU_phone()); 
            pstmt.setString(5, vo.getU_gender()); 
            pstmt.setString(6, vo.getU_id());
            
            int updateCount = pstmt.executeUpdate();

            if (updateCount == 1) 
                success = true;
            
        } catch(SQLException se){
            se.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
        	close(pstmt);
			close(conn);
        }
        return success;
	}

	/**********************************************************
	* userDelete() 메서드: 회원정보 탈퇴 처리 메서드
	* @param UserVO
	* @return boolean
	***********************************************************/
	public boolean userDelete(String u_id) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            
            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE b_user SET u_st = 1 WHERE u_id = ?");

            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, u_id); 
            
            int updateCount = pstmt.executeUpdate();

            if (updateCount == 1) 
                success = true;
            
        } catch(SQLException se){
            se.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
        	close(pstmt);
			close(conn);
        }
        return success;
	}


}
