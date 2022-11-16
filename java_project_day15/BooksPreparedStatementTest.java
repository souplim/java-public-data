package exam_jdbc;

import java.sql.*;
import java.util.Scanner;

public class BooksPreparedStatementTest {
    public static void showMenu(){
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 삭제");
        System.out.println("3. 데이터 검색");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String title, publisher, year;
        int choice, price;

        while(true){
            showMenu();
            choice = input.nextInt();
            input.nextLine(); // menu 값 입력하고 들어가는 enter 값 제어

            switch(choice){
                case 1:
                    System.out.println("추가할 책정보를 입력하시오.");
                    System.out.print("책제목 : ");
                    title = input.nextLine();
                    System.out.print("출판사 : ");
                    publisher = input.nextLine();
                    System.out.print("발행연도 : ");
                    year = input.nextLine();
                    System.out.print("가격 : ");
                    price = input.nextInt();
                    addBooks(title, publisher, year, price);
                    break;
                case 2:
                    System.out.print("삭제할 책번호를 입력하시오 : ");
                    int book_id = input.nextInt();
                    deleteBooks(book_id);
                    break;
                case 3:
                    readAllBooks();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    input.close();
                    return; // 메인 메서드 종료 -> 프로그램 종료
            }
        }
    }

    private static void addBooks(String title, String publisher, String year, int price){
        Connection con = ConnectDatabase.makeConnection("javauser","java1234");
        PreparedStatement pstmt = null;
        try {
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

            if(insertCount==1) {// 입력이 정상적으로 완료되면 반환값 1
                System.out.println("레코드 추가 성공");
//                con.commit(); 자동커밋 되므로 프로그램 상에서는 필요 없음
            }
            else
                System.out.println("레코드 추가 실패");
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(0);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static void deleteBooks(int book_id){
        Connection con = ConnectDatabase.makeConnection("javauser","java1234");
        PreparedStatement pstmt = null;

        try {
            StringBuffer sb = new StringBuffer();
            sb.append("DELETE FROM books WHERE book_id = ?");
            pstmt = con.prepareStatement(sb.toString());

            pstmt.setInt(1, book_id);

            int deleteCount = pstmt.executeUpdate();

            if(deleteCount==1) // 삭제가 정상적으로 완료되면 반환값 1
                System.out.println("레코드 삭제 성공");
            else
                System.out.println("레코드 삭제 대상이 존재하지 않음");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static void readAllBooks(){
        Connection con = ConnectDatabase.makeConnection("javauser","java1234");
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner input = new Scanner(System.in);

        try {
            StringBuffer sb = new StringBuffer();
            sb.append("SELECT book_id, title, publisher, year, price ");
            sb.append("FROM books ");

            pstmt = con.prepareStatement(sb.toString());

            rs = pstmt.executeQuery();
            System.out.println("**** BOOKS 테이블 데이터 출력 ****\n");
            System.out.printf("%s\t%-20s\t%6s\t%12s\t%s\n","책번호","책제목","출판사","출간연도","책가격");
            while(rs.next()){
                System.out.printf("%d %-26s %-13s %s %d\n", rs.getInt("book_id"), rs.getString("title"),rs.getString("publisher"),rs.getString("year"), rs.getInt("price"));
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println("[쿼리문 ERROR] \n"+e.getMessage());
            System.exit(0);
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
