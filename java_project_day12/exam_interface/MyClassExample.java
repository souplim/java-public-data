package exam_interface;

// 인터페이스
interface MyInterface {
    public void print();
}

// 구현클래스
class MyClass1 implements MyInterface {
    // 인터페이스에 정의된 추상메서드를 오버라이딩 해야한다.
    @Override
    public void print() { System.out.println("MyClass1"); }
}

// 구현클래스
class MyClass2 implements MyInterface {
    @Override
    public void print() { System.out.println("MyClass2"); }
}

public class MyClassExample {
    // 인터페이스명 참조변수 = new 구현클래스의 생성자() // 다형성
    public static void test(MyInterface mi){
        mi.print();
    }

    public static void main(String[] args) {
        MyClass1 mc1 = new MyClass1();
        MyClass2 mc2 = new MyClass2();
        mc1.print(); // MyClass1의 메소드를 직접 호출
        mc2.print(); // MyClass2의 메소드를 직접 호출
        System.out.println();

        // 인터페이스명 참조변수 = new 인터페이스명() // 이름이 없는 클래스에 상속받은 객체
        MyInterface mi = new MyInterface() {
            @Override
            public void print() {
                System.out.println("익명 클래스로 구현");
            }
        };
        test(mc1); // MyClass1의 참조값을 인자로 전달
        test(mi); // 익명클래스의 참조값을 인자로 전달. 결과는 익명클래스로 구현
        mi.print(); // 익명클래스로 구현
        System.out.println();

        (new MyInterface(){
            @Override
            public void print() {
                System.out.println("선언, 생성, 호출을 한번에 처리");
            }
        }).print(); // 선언, 생성, 호출을 한번에 처리
        System.out.println();

        test(new MyInterface() {
            @Override
            public void print() {
                System.out.println("메서드 호출 시 선언, 생성");
            }
        });
        System.out.println();

        MyInterface mi2 = test2();
        mi2.print(); // test2() 메서드에서 반환된 MyInterface를 구현한 구현 클래스의 주소값

    }

    public static MyInterface test2(){
        MyInterface mi = new MyInterface() {
            @Override
            public void print() {
                System.out.println("test2()메서드에서 반환된 MyInterface");
            }
        };
        return mi;
    }
}
