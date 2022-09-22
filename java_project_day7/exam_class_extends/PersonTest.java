package exam_class_extends;

class Person2{
    protected String name;
    protected int age;

    public void setName(){ this.name = name;}
    public String getName(){ return name; }
}

class Student2 extends Person2{

}

class ForeignStudent extends Student2 {

}

public class PersonTest {
    public static void main(String[] args) {

    }
}
