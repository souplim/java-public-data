package student_management;

import java.sql.*;
import java.util.ArrayList;

/* DAO(Data Access Object) 클래스가 데이터 처리의 궁극적인 단계이다.
 * CRUD 프로그램 구현
 * 기본적인 데이터 처리 기능인 입력(create, insert), 조회(read(또는 retrieve), select), 수정(update),
 * 삭제(delete) 기능을 구현한 데이터베이스 프로그램*/
public class StudentDAO {
    // 데이터베이스 연결 관련 상수 선언
    private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static final String USER = "javauser";
    private static final String PASSWD = "java1234";

    // 싱글톤
    private static StudentDAO instance = null;
    // 외부에서 호출할 수 있는 정적메소드 선언하여 인스턴스를 반환
    public static StudentDAO getInstance(){
        if(instance == null)
            instance = new StudentDAO();
        return instance;
    }
    // 외부에서 접근할 수 없도록 한 생성자
    private StudentDAO(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
        return con;
    }

    // 학생테이블에서 모든 레코드 반환하는 메서드
    public ArrayList<StudentVO> getStudentTotal(StudentVO vo){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date FROM STUDENT ");
        if(vo != null)
            sql.append("WHERE sd_num LIKE ? ");
        sql.append("ORDER BY no");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentVO svo = null;
        ArrayList<StudentVO> list = new ArrayList<>();

        try {
            conn = getConnection(); // 여기서 만든 메서드 호출하여 서버연결
            pstmt = conn.prepareStatement(sql.toString());
            if(vo!=null)
                pstmt.setString(1, "%"+vo.getSd_num()+"%");
            rs = pstmt.executeQuery();

            while(rs.next()){
                svo = new StudentVO();
                svo.setNo(rs.getInt("no"));
                svo.setSd_num(rs.getString("sd_num"));
                svo.setSd_name(rs.getString("sd_name"));
                svo.setSd_id(rs.getString("sd_id"));
                svo.setSd_passwd(rs.getString("sd_passwd"));
                svo.setS_num(rs.getString("s_num"));
                svo.setSd_birth(rs.getString("sd_birth"));
                svo.setSd_phone(rs.getString("sd_phone"));
                svo.setSd_address(rs.getString("sd_address"));
                svo.setSd_email(rs.getString("sd_email"));
                svo.setSd_date(rs.getDate("sd_date"));

                list.add(svo);
            }
        } catch (SQLException se){
            System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch (Exception e){
            System.out.println("ERROR=["+e+"]");
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                System.out.println("DB 연동 해제 ERROR = ["+e+"]");
            }
        }
        return list;
    }

    // 학번 자동 구하기
    public String getStudentNum(StudentVO vo){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT SUBSTR(TO_CHAR(sd_date,'YYYY-MM-DD'),3,2)||NVL(LPAD(MAX(TO_NUMBER(LTRIM(?,'0')))+1,2,'0'),'01')||LPAD(NVL(MAX(no),1),4,'0') AS studentNum FROM student");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sdnum = "";

        try {
            conn = getConnection(); // 여기서 만든 메서드 호출하여 서버연결
            pstmt = conn.prepareStatement(sql.toString());
            if(vo!=null)
                pstmt.setString(1, vo.getS_num());
            rs = pstmt.executeQuery();

            while(rs.next())
                sdnum = rs.getString("studentNum");
        } catch (SQLException e){
            System.out.println("조회에 문제가 있어 잠시 후에 다시 진행해주세요");
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                System.out.println("DB 연동 해제 ERROR = ["+e+"]");
            }
        }
        return sdnum;
    }

    public boolean studentInsert(StudentVO svo){
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO STUDENT(NO, SD_NUM, SD_NAME, SD_ID, SD_PASSWD, S_NUM, SD_BIRTH, SD_PHONE, SD_ADDRESS, SD_EMAIL) " +
                "VALUES(STUDENT_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, svo.getSd_num());
            pstmt.setString(2, svo.getSd_name());
            pstmt.setString(3, svo.getSd_id());
            pstmt.setString(4, svo.getSd_passwd());
            pstmt.setString(5, svo.getS_num());
            pstmt.setString(6, svo.getSd_birth());
            pstmt.setString(7, svo.getSd_phone());
            pstmt.setString(8, svo.getSd_address());
            pstmt.setString(9, svo.getSd_email());

            int insertCount = pstmt.executeUpdate();

            if(insertCount == 1)
                success = true;
        } catch (SQLException e){
            System.out.println("입력에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch (Exception e){
            System.out.println("ERROR=["+e+"]");
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                System.out.println("DB 연동 해제 ERROR=["+e+"]");
            }
        }
        return success;
    }

    public boolean studentUpdate(StudentVO svo) { // 어떤 부분을 수정하게 만들것인가? 일단 전부 수정하게 하기
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE STUDENT SET sd_name=?, sd_id=?, sd_passwd=?, s_num=?, sd_birth=?, sd_phone=?, sd_address=?, sd_email=? WHERE sd_num = ?");

        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, svo.getSd_name());
            pstmt.setString(2, svo.getSd_id());
            pstmt.setString(3, svo.getSd_passwd());
            pstmt.setString(4, svo.getS_num());
            pstmt.setString(5, svo.getSd_birth());
            pstmt.setString(6, svo.getSd_phone());
            pstmt.setString(7, svo.getSd_address());
            pstmt.setString(8, svo.getSd_email());
            pstmt.setString(9, svo.getSd_num());

            int updateCount = pstmt.executeUpdate();

            if(updateCount==1) {
                success = true;
                System.out.println("수정이 정상적으로 완료되었습니다.");
            }
        } catch (SQLException e){
            System.out.println("수정에 문제가 있어 잠시 후에 다시 진행해주세요");
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e){
                System.out.println("DB 연동 해제 ERROR = ["+e+"]");
            }
        }
        return success;
    }

    public boolean studentDelete(StudentVO svo) {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM STUDENT WHERE sd_num = ?");

        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql.toString());

            pstmt.setString(1, svo.getSd_num()); // update, delete의 기준은 기본키

            int insertCount = pstmt.executeUpdate();

            if (insertCount == 1) // 삭제가 정상적으로 완료되면 적용된 행의 수인 1 반환
                success = true;
        } catch(SQLException se){
            System.out.println("삭제에 문제가 있어 잠시 후에 다시 진행해주세요");
        } catch(Exception e){
            System.out.println("ERROR=[" + e + "]");
        } finally{
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("DB 연동 해제 ERROR = [" + e + "]");
            }
        }
        return success;
    }
}
