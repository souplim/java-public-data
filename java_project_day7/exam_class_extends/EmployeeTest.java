package exam_class_extends;

/* 직원(Employee)과 매니저(Manager)의 예를 들어보자.
 * 직원은 이름(name), 주소(address), 전화번호(phoneNumber), 월급(salary) 필드가 필요하고
 * 매니저는 이름, 주소, 전화번호, 월급, 보너스(bonus), 직책(job)을 필드로 갖는다.
 * 생성자, 설정자, 접근자를 생성하여 보자.*/
class Employee2 {
    private String name;
    private String address;
    private String phoneNumber;
    private int salary;

    // 생성자 추가
    public Employee2(){ }
    public Employee2(String name, String address, String phoneNumber, int salary){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    // 전체 필드 설정하기 위한 메서드(직원정보)
    public void setEmpData(String name, String address, String phoneNumber, int salary){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public String toString(){
        return name+" : "+address+" : "+phoneNumber+" : "+salary;
    }
}

class Manager extends Employee2{
    private int bonus;
    private String job;

    // 생성자
    public Manager(){ }
    public Manager(String name, String address, String phoneNumber, int salary, int bonus, String job){
        super(name, address, phoneNumber, salary);
        this.bonus = bonus;
        this.job = job;
    }

    // 전체 필드 설정하기 위한 메서드(관리자정보)
    public void setMgrData(String name, String address, String phoneNumber, int salary, int bonus, String job){
        // 직원 클래스의 setEmpData()를 통해 직원에 정의된 필드 설정
        super.setEmpData(name, address, phoneNumber, salary);
        // 자신이 가진 필드 설정
        this.bonus = bonus;
        this.job = job;
    }

    public int getBonus() { return bonus; }
    public void setBonus(int bonus) { this.bonus = bonus; }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    // super 키워드를 통해 부모 클래스의 필드와 메서드 호출
    public String toString(){
        return super.toString()+" : "+bonus+" : "+job;
    }
}

public class EmployeeTest{
    public static void main(String[] args) {
        // 실행결과 1
        Employee2 e1 = new Employee2();
        e1.setEmpData("홍길동", "역삼동", "010-1234-5678", 500);
        System.out.println(e1);

        Manager m = new Manager();
        m.setMgrData("임은재", "역삼동","010-1234-5678", 700, 5000, "대리");
        System.out.println(m);

        // 실행결과 2
        Employee2 e2 = new Employee2("홍길동", "역삼동", "010-1234-5678", 500);
        Manager m2 = new Manager("임은재", "역삼동","010-1234-5678", 700, 5000, "과장");
        System.out.println(e2);
        System.out.println(m2);

        // 실행결과 3 - 객체 배열. 슈퍼클래스[] 배열명 = { new 슈퍼클래스생성자(), new 서브클래스생성자()};
        // Employee[] e = new Employee[2];
        // e[0] = new Employee2("홍길동", "역삼동", "010-1234-5678", 500);
        // e[1] = new Manager("임은재", "역삼동","010-1234-5678", 700, 5000, "부장");
        Employee2[] e = {
                new Employee2("홍길동", "역삼동", "010-1234-5678", 500),
                new Manager("임은재", "역삼동","010-1234-5678", 700, 5000, "부장")
        };

        for(int i=0; i<e.length; i++){
            System.out.println(e[i]);
//            System.out.println(e[i].toString()); // 위와 동일 코드
        }

        for(Employee2 ee : e)
            System.out.println(ee);
    }
}
