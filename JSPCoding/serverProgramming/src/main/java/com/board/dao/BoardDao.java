package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.board.vo.Board;
import static com.board.common.JDBCTemplate.*;

public class BoardDao {
	public ArrayList<Board> listBoard(){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT boardnum, boardwriter, boardtitle, boardcontent, boarddate ");
		sql.append("FROM board ORDER BY boardnum");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		ArrayList<Board> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				board.setBoardNum(rs.getInt("boardnum"));
				board.setBoardWriter(rs.getString("boardwriter"));
				board.setBoardTitle(rs.getString("boardtitle"));
				board.setBoardContent(rs.getString("boardcontent"));
				board.setBoardDate(rs.getString("boarddate"));
				
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
	
	public boolean insertBoard(Connection conn, Board board){
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO BOARD(boardnum, boardwriter, boardtitle, boardcontent, boarddate) ");
		sql.append("VALUES((SELECT DECODE(MAX(boardnum), NULL, 0, MAX(boardnum)) + 1 FROM board), ?, ?, ?, sysdate)");
		
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, board.getBoardWriter());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			
			int insertCount = pstmt.executeUpdate();
			
			if(insertCount == 1) {
				success = true;
				commit(conn);
			}
		} catch (SQLException se) {
			se.printStackTrace();
			rollback(conn);
		} catch (Exception e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
			close(conn); 
		}
		
		return success;
	}
	
	public boolean updateBoard(Connection conn, Board board){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE BOARD SET boardtitle = ?, boardwriter = ?, boardcontent = ? WHERE boardnum = ?");

        PreparedStatement pstmt = null;
        boolean success = false;

        try {
//            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, board.getBoardTitle());
            pstmt.setString(2, board.getBoardWriter()); 
            pstmt.setString(3, board.getBoardContent());
            pstmt.setInt(4, board.getBoardNum()); 
            
            int updateCount = pstmt.executeUpdate();

            if (updateCount == 1) { 
                success = true;
                commit(conn);
            }
        } catch(SQLException se){
            se.printStackTrace();
            rollback(conn);
        } catch(Exception e){
            e.printStackTrace();
            rollback(conn);
        } finally{
        	close(pstmt);
			close(conn);
        }
        return success;
    }
	
	public boolean deleteBoard(Connection conn, Board board){
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM board WHERE boardnum = ?");

        PreparedStatement pstmt = null;
        boolean success = false;

        try {
//            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setInt(1, board.getBoardNum()); // update, delete의 기준은 기본키

            int deleteCount = pstmt.executeUpdate();

            if (deleteCount == 1) { // 삭제가 정상적으로 완료되면 적용된 행의 수인 1 반환
                success = true;
                commit(conn);
            }
        } catch(SQLException se){
            System.out.println("삭제에 문제가 있어 잠시 후에 다시 진행해주세요");
            rollback(conn);
        } catch(Exception e){
            System.out.println("ERROR=[" + e + "]");
            rollback(conn);
        } finally{
            close(pstmt);
            close(conn);
        }
        return success;
    }
	
}