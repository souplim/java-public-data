package exam_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesSelectTest {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int employee_id, salary;
        String first_name, department_name;

        try {
            con = ConnectDatabase.makeConnection("hr","hr1234");
            stmt = con.createStatement();
            // SELECT employee_id, first_name, salary, department_name FROM employees e INNER JOIN deparments d ON e.department_id = d.department_id
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT employee_id, first_name, salary, TO_CHAR(hire_date,'YYYY.MM.DD') hire_date, department_name "); // 함수 사용할 경우 별칭 주어야
            sql.append("FROM employees e INNER JOIN departments d ");
            sql.append("ON e.department_id = d.department_id");
            rs = stmt.executeQuery(sql.toString());

            System.out.println("**** EMPLOYEES 테이블 데이터 출력 ****\n");
            System.out.printf("%s\t%s\t%6s\t%8s\t%7s\n","사원번호","사원이름","급여","입사일","부서명");

            while(rs.next()){
                System.out.printf("%-7d %-11s %-6d %s %s\n", rs.getInt("employee_id"), rs.getString("first_name"), rs.getInt("salary"), rs.getString("hire_date"), rs.getString("department_name"));
            }
        } catch (SQLException e) {
            System.err.println("[쿼리문 ERROR] \n"+e.getMessage());
        } finally {
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();
            } catch (SQLException e){
                System.out.println("CLOSE ERROR");
            }
        }
    }
}
