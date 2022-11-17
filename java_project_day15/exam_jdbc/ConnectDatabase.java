package exam_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection makeConnection(String id, String password){ // Connection 인스턴스 반환
        String url = "jdbc:oracle:thin:@127.0.0.1:1521/xepdb1";
        Connection con = null;
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle 9 이전
            Class.forName("oracle.jdbc.OracleDriver"); // Oracle 9 이후
            System.out.println("드라이버 적재 성공");

            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch(ClassNotFoundException e){
            System.out.println("드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch(SQLException e){
            System.out.println("연결에 실패하였습니다.");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = makeConnection("javauser","java1234");
        con.close(); // 해제할 때 예외처리 메인메서드에 미룸
    }
}
