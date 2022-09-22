package exam_class_extends;

class Person {
    private String name;
    private int age;

    public Person(){ }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getAge(){ return age; }
    public void setAge(int age){ this. age = age; }

    public String toString(){
        return name+":"+age;
    }
}

class Employee extends Person {
    private String dept;
    public Employee(){ super(); }

    public String getDept(){ return dept; }
    public void setDept(String dept){ this.dept = dept; }

    public String toString(){
        return super.toString() + ":" + getDept();
    }
}

class Professor extends Person {
    private String subject;

    public String getSubject(){ return subject; }
    public void setSubject(String subject){ this.subject = subject; }

    public String toString(){
        return super.toString()+":"+getSubject();
    }
}

class Student extends Person {
    private String major;

    public String getMajor(){ return major; }
    public void setMajor(String major){ this.major = major; }

    public String toString(){
        return super.toString()+":"+getMajor();
    }
}

/* [실행결과]
 * 홍길동:47:행정지원팀
 * 김푸름:52:데이터베이스
 * 김유빈:20:자바 프로그래밍 과정
 */
/* 직원(Employee)과 매니저(Manager)의 예를 들어보자*/
public class InheritanceTest {
    public static void main(String[] args) {
        Employee e = new Employee();
        Professor p = new Professor();
        Student s = new Student();

        e.setName("홍길동");
        e.setAge(47);
        e.setDept("행정지원팀");

        p.setName("김푸름");
        p.setAge(52);
        p.setSubject("데이터베이스");

        s.setName("김유빈");
        s.setAge(20);
        s.setMajor("자바 프로그래밍 과정");

        System.out.println(e.toString());
        System.out.println(p.toString());
        System.out.println(s.toString());
    }
}