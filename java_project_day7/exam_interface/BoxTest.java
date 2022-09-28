package exam_interface;

/* 자바에서는 객체의 크기를 비교하는데 사용되는 Comparable 인터페이스를 제공해 준다(자바 API가 제공하는 인터페이스).
 * public interface Comparable {
       // 이 객체가 다른 객체보다 크면 1, 같으면 0, 작으면 -1을 반환한다.
       int compareTo(Object other);
 * }
*/

@SuppressWarnings("rawtypes")
class Box implements Comparable{
    private double volume;

    public Box(double volume){
        this.volume = volume;
    }

    public double getVolume(){ return volume; }

    @Override
    public int compareTo(Object obj){ // Object obj = b2 업캐스팅
        Box other = (Box)obj; // (서브클래스명)부모클래스의 참조변수. 다운캐스팅. 자식변수가 필요하기 때문에 형변환하면 접근할 수 있는 범위 확대됨
        if(this.volume < other.volume) // this -> b1이 가지고 있는 볼륨 other -> b2가 가지고 있는 볼륨
            return -1;
        else if(this.volume > other.volume)
            return 1;
        else
            return 0;
    }
}

/*Box라는 이름으로 클래스를 생성하고 실수형으로 필드(volume)를 하나 가진다.
실행클래스를 생성하여 두개의 객체를 생성하여 두 객체의 필드 값을 비교하여 큰지 작은지 같은지를 판별하도록 코드를 작성하여 보자.*/
public class BoxTest {
    public static void main(String[] args) {
        Box b1 = new Box(100.4);
        Box b2 = new Box(85.0);

        if(b1.getVolume() > b2.getVolume())
            System.out.println("b1이 b2보다 더 크다");
        else
            System.out.println("b1이 b2보다 같거나 작다");

        if(b1.compareTo(b2) > 0)
            System.out.println("b1이 b2보다 더 크다");
        else
            System.out.println("b1이 b2보다 같거나 작다");
    }
}
