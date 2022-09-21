package exam_class_extends;

class Employee2 {
    private String name;
    private String address;
    private String phoneNumber;
    private int salary;

    public void setEmpData(String name, String address, String phoneNumber, int salary){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String toString(){
        return name+" : "+address+" : "+phoneNumber+" : "+salary;
    }
}

class Manager extends Employee2{
    private int bonus;
    private String job;

    public void setMgrData(String name, String address, String phoneNumber, int salary, int bonus, String job){
        super.setEmpData(name, address, phoneNumber, salary);
        this.bonus = bonus;
        this.job = job;
    }

    public String toString(){
        return super.toString()+" : "+bonus+" : "+job;
    }
}

public class EmployeeTest{
    public static void main(String[] args) {
        Employee2 e = new Employee2();
        e.setEmpData("홍길동", "역삼동", "010-1234-5678", 500);
        System.out.println(e);

        Manager m = new Manager();
        m.setMgrData("임은재", "역삼동","010-1234-5678", 700, 5000, "대리");
        System.out.println(m);
    }
}
