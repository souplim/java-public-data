package exam_jdbc;

import java.sql.*;

public class BooksInsertTest {
    public static void main(String[] args){
        addBooks("이것이 우분투 리눅스다","한빛미디어","2020", 32000);
        addBooks("오늘부터 개발자","천그루숲","2021", 15000);
    }

    private static void addBooks(String title, String publisher, String year, int price){
        Connection con = ConnectDatabase.makeConnection("javauser","java1234");
        //Statement stmt = null;
        PreparedStatement pstmt = null;
        try {
            // Statement 사용방법
            /*stmt = con.createStatement();

            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO BOOKS(book_id, title, publisher, year, price) ");
            sql.append("VALUES(books_seq.nextval, "+"'"+title+"' , '"+publisher+"', '"+year+"', "+price+")");

            System.out.println("쿼리문 확인: "+sql);

            int insertCount = stmt.executeUpdate(sql.toString()); // 쿼리문 실행하여 적용된 행의 반환
            */
            // PreparedStatement 사용방법
            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO BOOKS(book_id, title, publisher, year, price) ");
            sb.append("VALUES(books_seq.nextval, ?, ?, ?, ?)");

            // 칼럼이 많아질수록 PreparedStatement가 더 편리
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, title);
            pstmt.setString(2, publisher);
            pstmt.setString(3, year);
            pstmt.setInt(4, price);

            int insertCount = pstmt.executeUpdate();

            if(insertCount==1) // 입력이 정상적으로 완료되면 반환값 1
                System.out.println("레코드 추가 성공");
            else
                System.out.println("레코드 추가 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            try {
                //if(stmt != null) stmt.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
