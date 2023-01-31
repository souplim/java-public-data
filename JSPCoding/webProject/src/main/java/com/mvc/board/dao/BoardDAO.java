package com.mvc.board.dao;

import com.mvc.board.vo.BoardVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.mvc.common.util.JDBCTemplate.*;

public class BoardDAO {
	private static BoardDAO instance = null;
	public static BoardDAO getInstance() {
		if(instance==null)
			instance = new BoardDAO();
		return instance;
	}	
	
	// BoardDAO 클래스에 메서드 내용만 작성해 주세요

	/*********************************************************
	* boardList() 메서드: 게시판 목록 조회(검색 처리 제외)
	* @return ArrayList<BoardVO> 리턴.
	**********************************************************/
	public ArrayList<BoardVO> boardList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		ArrayList<BoardVO> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num, author, title, to_char(writeday, 'YYYY/MM/DD') writeday, ");
			sql.append("readcnt, repRoot, repStep, repIndent ");
			sql.append("FROM board2 ORDER BY repRoot desc, repStep asc");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setAuthor(rs.getString("author"));
				board.setTitle(rs.getString("title"));
				board.setWriteday(rs.getString("writeday"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setRepRoot(rs.getInt("repRoot"));
				board.setRepStep(rs.getInt("repStep"));
				board.setRepIndent(rs.getInt("repIndent"));
				
				list.add(board);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return list;
	}


	/**********************************************************
	* boardInsert() 메서드: 게시물 등록
	* @return boolean 리턴.
	***********************************************************/
	public boolean boardInsert(BoardVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO board2(num, author, title, content, reproot, repstep, repindent, passwd) ");
			sql.append("VALUES(board2_seq.nextval, ?, ?, ?, board2_seq.currval, 0, 0, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getAuthor());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPasswd());
			
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

	/***********************************************************
	* readCount() 메서드: 조회수 증가 처리 메서드.
	* @param 게시물 번호. 
	***********************************************************/
	public void readCount(String num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE board2 SET readcnt = readcnt + 1 WHERE num=?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}


	/**********************************************************
	* boardDetail() 메서드: 상세 페이지 처리 메서드.
	* @param 게시물 번호. 번호를 숫자로 받은 이유는 필요시 변환하여 사용하기 때문에.
	* @return BoardVO 리턴
	***********************************************************/
	public BoardVO boardDetail(String num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO data = new BoardVO();
		
		try {
			conn = getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num, author, title, content, to_char(writeday, 'YYYY/MM/DD HH24:MI:SS') writeday, ");
			sql.append("readcnt, repRoot, repStep, repIndent ");
			sql.append("FROM board2 WHERE num = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWriteday(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				data.setRepRoot(rs.getInt("repRoot"));
				data.setRepStep(rs.getInt("repStep"));
				data.setRepIndent(rs.getInt("repIndent"));
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
	* boardUpdate() 메서드: 게시물 수정 처리 메서드
	* @param BoardVO
	* @return boolean
	***********************************************************/
	public boolean boardUpdate(BoardVO vo) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            
            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE board2 SET title = ?, content = ? "); // 제목과 내용은 변경된 내용이, 기존값 그대로
            if(vo.getPasswd()!="") sql.append(", passwd = ? ");		 // 비밀번호는 변경할 수도 하지 않을 수도 있음
            sql.append("WHERE num = ?");							 // 수정의 기준은 글번호
           
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent()); 
            
            if(vo.getPasswd()!="") { // 빈문자 제어(updateBoardController)
            	pstmt.setString(3, vo.getPasswd());
            	pstmt.setInt(4, vo.getNum());
            } else {
            	pstmt.setInt(3, vo.getNum());
            }
            
            int updateCount = pstmt.executeUpdate();

            if (updateCount == 1) { 
                success = true;
            }
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
	* boardDelete() 메서드: 게시물 삭제 처리 메서드
	* @param 게시물 전호, 비밀번호
	***********************************************************/
	public void boardDelete(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
        try {
            conn = getConnection();

        	StringBuffer sql = new StringBuffer();
            sql.append("DELETE FROM board2 WHERE num = ?");
        	
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, Integer.parseInt(num)); // update, delete의 기준은 기본키
            pstmt.executeUpdate();
        } catch(SQLException se){
        	se.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            close(pstmt);
            close(conn);
        }
	}
}

