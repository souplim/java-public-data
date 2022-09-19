package exam_class_constructor;

class CarConstructor {
    private int speed;
    private int gear;
    private String color;

    // 생성자
    public CarConstructor(){
        this(0, 1, "red");
    }
    public CarConstructor(int speed, int gear, String color){
        this.speed = speed;
        this.gear = gear;
        this.color = color;
    }

    public int getSpeed(){ return speed; }
    public int getGear(){ return gear; }
    public String getColor(){ return color; }

    public String toString(){
        return "자동차 정보 [속도="+speed+", 기어="+gear+", 색상="+color+"]";
    }
}

public class CarContructorTest {
    public static void main(String[] args) {
        CarConstructor c1 = new CarConstructor(60, 1, "blue");
        System.out.println(c1.toString());

        CarConstructor c2 = new CarConstructor();
        System.out.println(c2.toString());
    }
}
