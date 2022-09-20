package exam_class_static;

public class StaticMethodTest {
    // static 변수 선언. 위치는 메인메서드 밖. private, static 변수 안에 있으면 왜 안 될까?
    private static int num1 = 5;
    private int num2 = 3;       // 인스턴스 변수

    public static void main(String[] args) {
        StaticMethodTest.print1(); // 클래스명.정적메서드()로 호출
        print1(); // 같은 클래스 안에서 사용할 때에는 클래스명 생략 가능

//        StaticMethodTest.print2(); // 에러. 인스턴스 생성해야 사용 가능한 인스턴스 메서드임
//        print2();

        StaticMethodTest method = new StaticMethodTest();
        method.print2(); // 객체 생성 후에는 호출 잘 됨
    }


    public static void print1(){ // 정적 메서드. 클래스 메서드
        int num3 = num1;
//        int num4 = this.num2; // 에러
        System.out.println(num3);
        System.out.println("print1() 호출");
    }

    public void print2(){ // 인스턴스 메서드
        int num3 = num1;
        int num4 = num2;
        System.out.println(num3+","+num4);
        System.out.println("print2() 호출");
    }
}
