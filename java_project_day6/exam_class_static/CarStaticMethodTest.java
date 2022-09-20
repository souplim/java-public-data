package exam_class_static;

class CarStaticMethod{
    private int speed;
    private int gear;
    private String color;
    // 객체화된 Car 객체의 개수를 위한 static 변수
    private static int numberOfCars = 0;

    public CarStaticMethod(int speed, int gear, String color){
        this.speed = speed;
        this.gear = gear;
        this.color = color;
        ++numberOfCars;
    }

    // static메서드 - 대부분 static 변수에 접근하여 사용
    public static int getNumberOfCars(){ return numberOfCars; }
    public int getSpeed(){ return speed; }
    public void setSpeed(int speed){ this.speed = speed; }
    public int getGear(){ return gear; }
    public void setGear(int gear){ this.gear = gear; }
    public String getColor(){ return color; }
    public void setColor(String color){ this.color = color; }

    public String toString(){
        return "자동차 정보[ 속도 : "+speed+" 기어 : "+gear+" 색상 : "+color+" ]";
    }
}

public class CarStaticMethodTest {
    public static void main(String[] args) {
        CarStaticMethod c1 = new CarStaticMethod(90, 1, "blue");
        CarStaticMethod c2 = new CarStaticMethod(50, 0, "white");

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        int number = CarStaticMethod.getNumberOfCars();
        System.out.println("지금까지 생성된 자동차 수 = "+number);
    }
}
