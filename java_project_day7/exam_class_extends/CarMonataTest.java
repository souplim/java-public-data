package exam_class_extends;

/* [요구사항 2] 자동차 공장에서 Monata 자동차를 생산하려고 한다.
 * 아래의 실행 결과를 보고 색상/시리즈/용도별로 몇 대의 차량이 생산되어야 할지를 출력해 본다.
 * 다이어그램을 참조해서 클래스를 작성하고 실행결과와 같이 나올 수 있도록 구현하시오.
 */
class Car{
    private String color;
    private int account;

    Car(){ }
    public Car(String color, int account){
        this.color = color;
        this.account = account;
    }

    public String getColor(){ return color; }
    public int getAccount(){ return account; }

    public String toString(){
        return String.format("[색상] %-7s [생산수량] %-7d ",color,account);
    }
}

class Monata extends Car{
    private String series;
    private String use;

    public Monata(String color, int account, String series, String use){
        super(color, account);
        this.series = series;
        this.use = use;
    }

    public String toString(){
        return String.format(super.toString()+"[용도] %-7s [시리즈] %-7s ",series,use);
    }
}

public class CarMonataTest {
    public static void main(String[] args){
        Car c = new Car();
        Monata m = new Monata("흰색", 5000, "승용", "NF");

        System.out.println(m.toString());
    }
}
