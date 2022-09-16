package exam_class_basic;

class Car {
    public int speed; // 속도
    public int gear; // 기어단수
    public String color; // 색상

    Car(){ }

    Car(int s, int g, String c){
        this.speed = s;
        this.gear = g;
        this.color = c;
    }

    public void carData(int s, int g, String c){
        speed = s;
        gear = g;
        color = c;
    }
    
    public void speedUp(int s){ // 속도 증가 메서드. s: 매개변수
        speed+=s;
    }
    public void speedDown(int s){ // 속도 감소 메서드
        speed-=s;
    }
    public void printData(){ // 객체의 상태를 문자열로 출력하는 메서드
        System.out.println("속도: "+speed+"기어: "+gear+"색상: "+color);
    }

    public String toString(){ // 객체의 상태를 문자열로 반환하는 메서드
        return "속도: "+speed+"기어: "+gear+"색상: "+color;
    }
}

public class CarTest {
    public static void main(String[] args){
        // 클래스명 참조변수 = new 클래스명();
        Car c = new Car();// 첫번째 객체 생성

        // 각각의 필드에 값을 설정해주는 방법: 참조변수명.필드 = 값;
        c.speed = 0; // 객체의 필드 변경. 접근제어자가 public 이어서 가능
        c.gear = 1; // 객체의 필드 변경
        c.color = "red"; // 객체의 필드 변경

        // 객체의 메서드 호출: 참조변수명.메서드()
        c.speedUp(20);
        c.printData(); // 출력방법 1
        System.out.println("Car: "+c.toString()); // 출력방법2

        // 두번째 객체 생성
//        Car c2 = new Car();
//        c2.speed = 60;
//        c2.gear = 3;
//        c2.color = "blue";

        Car c2 = Car(60, 3, "blue");
        
        c2.speedDown(40);
        c2.printData();
        System.out.println("Car2: "+c.toString());
    }
}
