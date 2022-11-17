package exam_jdbc;

import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.*;

public class CallableStatementTest2 {
    public static void main(String[] args) {
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            con = ConnectDatabase.makeConnection("javauser","java1234");


            cstmt = con.prepareCall("{call books_select(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.executeQuery();

            rs = (ResultSet) cstmt.getObject(1); // 커서를 Object로 받아 형변환

            System.out.println("\n**** BOOKS 테이블 조회 데이터 ****");
            System.out.printf("%s\t%15s\t%10s\t%8s\t%5s\n","책번호","책제목","출판사","출간년도","책가격");

            while(rs.next()){
                System.out.printf("%-5d %-30s %-15s %-8s %-5d\n", rs.getInt("book_id"),rs.getString("title"),rs.getString("publisher"),rs.getString("year"),rs.getInt("price"));
            }
            
        } catch (SQLException s){
            System.out.println("오라클 서버 연동 후 쿼리 실행에 문제가 발생했습니다.");
        } catch (Exception e){
            System.err.println("ERROR("+e.getMessage()+")");
        } finally {
            try {
                if(rs != null) rs.close();
                if(cstmt != null) cstmt.close();
                if(con != null) con.close();
            } catch (Exception e){
                System.out.println("연결 해제 오류");
                e.printStackTrace();
            }
        }
    }
}
