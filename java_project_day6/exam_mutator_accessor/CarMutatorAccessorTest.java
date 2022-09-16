package exam_mutator_accessor;

class CarMutatorAccessor {
    private int speed; // 속도
    private int gear; // 기어단수
    private String color; // 색상

    // 생성자
    CarMutatorAccessor(){ }
    CarMutatorAccessor(int speed, int gear, String color){
        this.speed = speed;
        this.gear = gear;
        this.color = color;
    }

    // 설정자(Setter) / 접근자(Getter)
    public void setSpeed(int speed){ // 속도가 0 미만일 때 거르는 조건문 추가해주어야
        if(speed<0)
            this.speed = 0;
        this.speed = speed;
    }
    public int getSpeed(){ return speed; }
    public void setGear(int gear){ this.gear = gear; }
    public int getGear(){ return gear;}
    public void setColor(String color){ this.color = color; }
    public String getColor(){ return color; }

    // 메소드 정의
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
        return "자동차 상태정보 [ 속도: "+speed+", 기어: "+gear+", 색상: "+color+" ]";
    }
}

public class CarMutatorAccessorTest {
    public static void main(String[] args){
        // 첫번째 객체 생성
        CarMutatorAccessor c = new CarMutatorAccessor();
        // 설정자 메소드 호출
        c.setSpeed(0);
        c.setGear(1);
        c.setColor("red");

        // 두번째 객체 생성
        CarMutatorAccessor c2 = new CarMutatorAccessor(60, 3, "blue");

        // 접근자 메소드 호출
        System.out.println(c.getSpeed());
        System.out.println(c.getGear());
        System.out.println(c.getColor());
        System.out.println(c2.getSpeed());
        System.out.println(c2.getGear());
        System.out.println(c2.getColor());

        // 객체의 메서드 호출: 참조변수명.메서드()
        c.speedUp(20);
        c2.speedDown(30);
        // 출력
        c.printData(); // 출력방법 1
        System.out.println("Car: "+c2.toString()); // 출력방법2
    }
}
