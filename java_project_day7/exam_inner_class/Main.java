package exam_inner_class;

class A {
    private int num;
    static int number;

    A(){
        System.out.println("A 객체가 생성됨");
    }

    /** 내부 클래스 - 인스턴스 멤버 클래스 **/
    class B {
        int field1;
        static int value; // 인스턴스 멤버 클래스는 static 멤버를 가질 수 없다.

        B(){
            num = 5;
            number = 3;
            System.out.println("B 객체가 생성됨");
        }

        void method1(){
            System.out.println("num : "+num);
            System.out.println("number : "+number);
            System.out.println("field1 : "+field1);
        }
    }

    /** 내부 클래스 - static(정적) 멤버 클래스 **/
    static class C {
        int field1;
        static int field2;

        C(){
            // num = 10; // 정적 멤버 클래스는 외부 클래스의 인스턴스 멤버를 가질 수 없다.
            number = 9;
            System.out.println("C 객체가 생성됨");
        }

        void method1(){
            System.out.println("field1 : " + field1);
        }

        static void method2(){
            System.out.println("field2 : "+field2);
        }
    }

    void method(){
        /** 내부 클래스 - 로컬 클래스 **/
        class D{
            int field3;
            static int field4;
            D(){
                field4 = 3;
                System.out.println("D 객체가 생성됨");
            }

            void method1(){
                System.out.println("field3 : "+field3);
            }
        }
        D d = new D();
        d.field3 = 3;
        d.method1();
    }
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        // 인스턴스 멤버 클래스 객체 생성
        A.B b = a.new B();
        A.B b2 = new A().new B(); // 두 줄을 한 줄로

        b.field1 = 3;
        b.method1();
        System.out.println();

        // 정적 멤버 클래스 객체 생성
        A.C c = new A.C();
        c.field1 = 3;
        c.method1();
//        c.method2();

        A.C.field2 = 3; // 정적필드. 외부클래스.내부클래스.static 변수
        A.C.method2(); // 정적메서드. 외부클래스.내부클래스.static 메서드
        System.out.println();

        // 로컬 클래스 객체 생성을 위한 메소드 호출
        a.method();
    }
}
