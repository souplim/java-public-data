package exam_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksInsertTest {
    public static void main(String[] args){
        addBooks("이것이 우분투 리눅스다","한빛미디어","2020", 32000);
    }

    private static void addBooks(String title, String publisher, String year, int price){
        Connection con = ConnectDatabase.makeConnection("javauser","java1234");
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();

            StringBuffer sql = new StringBuffer();
            sql.append("INSERT INTO BOOKS(book_id, title, publisher, year, price) ");
            sql.append("VALUES(books_seq.nextval, "+"'"+title+"' , '"+publisher+"', '"+year+"', "+price+")");

            System.out.println("쿼리문 확인: "+sql);

            int insertCount = stmt.executeUpdate(sql.toString());
            if(insertCount==1) // 입력이 정상적으로 완료되면 반환값 1
                System.out.println("레코드 추가 성공");
            else
                System.out.println("레코드 추가 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            try {
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
