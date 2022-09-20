package exam_array;

class Car {
    private int speed;
    private int gear;
    private String color;

    public Car(){
        speed = 80;
        gear = 1;
        color = "red";
    }
    public Car(int speed, int gear, String color){
        this.speed = speed;
        this.gear = gear;
        this.color = color;
    }

    public void speedUp(){ speed += 10; }
    public String toString() {
        return "속도 : "+speed+" 기어 : "+gear+" 색상 : "+color;
    }
}

public class CarObjectArray {
    public static void main(String[] args) {
        Car c1, c2, c3, c4, c5; // 객체 선언
        c1 = new Car();         // 객체 생성
        c2 = new Car();
        c3 = new Car();
        c4 = new Car();
        c5 = new Car();

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(c5.toString());


        final int NUM_CARS = 5; // 상수 선언
        Car[] cars = new Car[NUM_CARS]; // 객체 배열 선언

        for(int i=0; i<cars.length; i++){
            cars[i] = new Car(); // 객체 생성
        }

        for(int i=0; i<cars.length; i++){
            cars[i].speedUp(); // 메서드 호출
        }

        for(int i=0; i<cars.length; i++){
            System.out.println("자동차("+(i+1)+") "+cars[i].toString()); // 인스턴스 변수 출력
        }

        // 매개변수 있는 생성자 이용한 객체 생성! 디폴트 값 보다는 내가 원하는 것 커스터마이징 하는 경우 많음
        Car[] cars2 = new Car[]{
                new Car(60, 1 ,"검정색"),
                new Car(90, 3, "회색"),
                new Car(0, 1, "검정색"),
                new Car(10, 2, "그린"),
                new Car(30, 2, "회색"),
                new Car(40, 1, "하얀색"),
        };

        Car[] cars3 = { // 생성과 동시에 초기화 할 때는 생략 가능
                new Car(60, 1 ,"검정색"),
                new Car(90, 3, "회색"),
                new Car(0, 1, "검정색"),
                new Car(10, 2, "그린"),
                new Car(30, 2, "회색"),
                new Car(40, 1, "하얀색"),
        };

        for(int i=0; i<cars2.length; i++){
            System.out.println("자동차("+(i+1)+") "+cars2[i].toString()); // 인스턴스 변수 출력
        }
    }
}
