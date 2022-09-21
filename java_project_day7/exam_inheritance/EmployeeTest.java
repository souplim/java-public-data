package exam_inheritance;

class Employee2 {
    private String name;
    private String address;
    private String phoneNumber;
    private int salary;

    public void set(String name, String address, String phoneNumber, int salary){
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

    public void setBonusJob(int bonus, String job){
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
        e.set("홍길동", "역삼동", "010-1234-5678", 500);

        Manager m = new Manager();
        m.set("임은재", "역삼동","010-1234-5678", 700);
        m.setBonusJob(5000, "웹개발자");

        System.out.println(e);
        System.out.println(m);
    }
}
