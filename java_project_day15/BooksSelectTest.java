package exam_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BooksSelectTest {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner input = new Scanner(System.in);

        try {
            con = ConnectDatabase.makeConnection("javauser","java1234");
            stmt = con.createStatement();

            System.out.print("검색할 책 제목을 입력해주세요 : ");
            String title = input.nextLine();

            StringBuffer sql = new StringBuffer();
            sql.append("SELECT book_id, title, publisher, year, price FROM BOOKS");
//            sql.append(" WHERE title = '"+title+"'"); // 정확한 제목
//            sql.append(" WHERE title LIKE '%"+title+"%'"); // 단어 포함
            rs = stmt.executeQuery(sql.toString());

            System.out.println("**** BOOKS 테이블 데이터 출력 ****\n");
            System.out.printf("%s\t%15s\t%10s\t%8s\t%5s\n","책번호","책제목","출판사","출간년도","책가격");

            while(rs.next()){
                System.out.printf("%-5d %-30s %-15s %-8s %-5d\n", rs.getInt("book_id"), rs.getString("title"),rs.getString("publisher"),rs.getString("year"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            System.err.println("[쿼리문 ERROR] \n"+e.getMessage());
        } finally {
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e) {
                System.out.println("CLOSE ERROR");
            }
        }
    }
}
