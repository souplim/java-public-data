package exam_class_basic;

/* 직원 정보를 저장할 Employee 클래스를 생성하여 보자.
 * 직원은 이름(name), 전화번호(phoneNumber), 급여(salary)를 필드로 가진다-접근제어자: public
 * 직원 정보를 실행 클래스에서 임의의 값으로 설정해준다.
 * 그 후 화면에 전체 필드의 내용이 출력되도록 작성한다.
 *
 * [실행 결과]
 * 직원정보[ 사원명: 홍길동, 전화번호 = 010-2345-3476, 급여 = 1000000 ]
 * 직원정보[ 사원명: 임은재, 전화번호 = 010-4355-8742, 급여 = 7000000 ]
 * */

class Employee{
    public String name;
    public String phoneNumber;
    public long salary;

    Employee(){ }
    Employee(String name, String phoneNumber, long salary){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setSalary(long salary){
        this.salary = salary;
    }
    public long getSalary(){
        return salary;
    }
    public void printData(){
        System.out.println("직원정보[ 사원명: "+name+", 전화번호 = "+phoneNumber+", 급여 = "+salary+" ]");
    }

    public String toString(){
        return "직원정보[ 사원명: "+name+", 전화번호 = "+phoneNumber+", 급여 = "+salary+" ]";
    }
}

public class EmployeeTest {
    public static void main(String[] args){
        Employee emp1 = new Employee();

        // 인스턴스 변수의 접근제어자가 public일 때 가능한 코드
        emp1.name = "홍길동";
        emp1.phoneNumber = "010-2345-7890";
        emp1.salary = 1000000;

        // 인스턴스 변수의 접근제어자가 private일 때 가능한 코드
        emp1.setName("홍길동");
        emp1.setPhoneNumber("010-2345-7890");
        emp1.setSalary(1000000);


        // 생성자 사용 인스턴스 변수 설정
        Employee emp = new Employee("임은재", "010-4355-8742", 70000000);

        // 출력방법 1
        emp1.printData();
        // 출력방법 2
        System.out.println(emp.toString());

    }
}
