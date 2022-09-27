package exam_instanceof;

class Parent{
    String field1;

    public void method1(){ System.out.println("Parent-method1()"); }
    public void method2(){ System.out.println("Parent-method2()"); }
}

//   자식클래스      부모클래스
class Child extends Parent{
    String field2;

    public void method3(){ System.out.println("Child-method3()"); }
}

public class InstanceofExample {
    // 슈퍼 클래스로부터 상속받은 필드와 메서드.
    // 단 서브클래스에서 오버라이딩하면 그때부터는 오버라이딩된 메서드를 호출.
    // 메서드명 (슈퍼클래스 참조변수) 슈퍼 클래스 참조변수 = 서브클래스의 참조값. 업캐스팅.

    // 메인메서드에서 인스턴스 생성하지 않고 쓸 거라 static
    public static void method1(Parent parent){ // Parent parent = parentA
        if(parent instanceof Child) { // parent 참조변수가 참조하는 인스턴스의 타입이 Child이면
            // 서브클래스의 필드와 메서드
            Child child = (Child) parent; // 서브클래스 참조변수 = (서브클래스)슈퍼클래스타입 참조변수. 다운캐스팅
            child.field2 = "Child로 변환 성공";
            System.out.println("method1 - " + child.field2);
        } else
            System.out.println("method1 - Child로 변환되지 않음");
    }

    public static void method2(Parent parent){ // Parent parent = parentB
        Child child = (Child)parent;
        child.field2 = "Child로 변환 성공";
        System.out.println("method2 - "+child.field2);
    }

    public static void main(String[] args) {
        // 슈퍼클래스 참조변수 = new 서브클래스의 생성자(). 업캐스팅
        Parent parentA = new Child();
        method1(parentA); // 메서드명(서브클래스의 참조값)
        method2(parentA); // 메서드명(서브클래스의 참조값)

        // 클래스 참조변수 = new 생성자(). 현재 업캐스팅X
        Parent parentB = new Parent();
        method1(parentB); // 메서드명(슈퍼클래스의 참조값) // instanceof 조건식에서 false 떠서 변환되지 않음 뜸
        // method2(parentB); // 메서드명(슈퍼클래스의 참조값) 조상 객체를 자손타입 참조변수가 가리킬 수 없으므로 에러남
    }
}
