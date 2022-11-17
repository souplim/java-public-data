package exam_jdbc;

import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.InputMismatchException;

public class CallableStatementTest3 {
    static void books_input(String title, String publisher, String year, int price){
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs;
        try {
            con = ConnectDatabase.makeConnection("javauser","java1234");

            cstmt = con.prepareCall("{call books_input(?, ?, ?, ?, ?)}");
            cstmt.setString(1, title);
            cstmt.setString(2, publisher);
            cstmt.setString(3, year);
            cstmt.setInt(4, price);
            cstmt.registerOutParameter(5, Types.VARCHAR);
            
            cstmt.executeQuery();
            System.out.println(cstmt.getString(5));
        } catch (InputMismatchException i) {
            System.out.println("입력값이 잘못되었습니다.");
        } catch (SQLException s){
            System.out.println("오라클 서버 연동 후 쿼리 실행에 문제가 발생했습니다.");
        } catch (Exception e){
            System.err.println("ERROR("+e.getMessage()+")");
        } finally {
            try {
                if(cstmt != null) cstmt.close();
                if(con != null) con.close();
            } catch (Exception e){
                System.out.println("연결 해제 오류");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        books_input("이것이 우분투 리눅스다","한빛미디어","2020", 32000);
        books_input("오늘부터 개발자","천그루숲","2021", 15000);
    }
}
