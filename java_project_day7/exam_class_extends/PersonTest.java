package exam_class_extends;

/* [요구사항 1] 다음 표와 실행 결과를 참고해서 답하라.
 * show()메서드의 객체의 정보를 문자열로 반환한다.
 * Person, Person의 서브 클래스가 Student, Student의 서브 클래스가 ForeignStudent를 작성한다.
 * 각각의 인스턴스를 생성하여 아래와 같은 결과를 출력하면 된다.
 * [실행결과] 사람[이름 : 홍길동, 나이 : 56]
 *           학생[이름 : 하늘봄, 나이 : 41, 학번 : 99010001
 *           외국학생[이름 : Olivia, 나이 : 39, 학번 : 97060004, 국적 : U.S.A]
 */
class Person2{
    private String name;
    private int age;

    Person2(){ }
    Person2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){ this.name = name;}
    public String getName(){ return name; }
    public void setAge(int age){ this.age = age; }
    public int getAge(){ return age;}

    public void show(){
        System.out.print("[이름 : "+getName()+", 나이 : "+getAge());
    }
}

class Student2 extends Person2{
    private int stuNum;
    Student2(){ }
    Student2(String name, int age, int stuNum){
        super(name, age);
        this.stuNum = stuNum;
    }

    public int getStuNum() { return stuNum; }
    public void setStuNum(int stuNum) { this.stuNum = stuNum; }

    @Override
    public void show(){
        super.show();
        System.out.print(", 학번 : "+stuNum);
    }
}

class ForeignStudent extends Student2 {
    private String nationality;

    ForeignStudent(String name, int age, int stuNum, String nationality){
        super(name, age, stuNum);
        this.nationality = nationality;
    }
    ForeignStudent(){ }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    @Override
    public void show(){
        super.show();
        System.out.print(", 국적 : "+nationality);
    }
}

public class PersonTest {
    public static void main(String[] args) {
        // 이런 비효율적인 방법 말고는 없나?ㅜ
        System.out.print("사람");
        Person2 p = new Person2("홍길동", 56);
        p.show();
        System.out.println("]");

        System.out.print("학생");
        Student2 s = new Student2("한늘봄", 41, 99010001);
        s.show();
        System.out.println("]");

        System.out.print("외국학생");
        ForeignStudent fs = new ForeignStudent("Olivia", 39, 97060004, "U.S.A");
        fs.show();
        System.out.println("]");
    }
}
