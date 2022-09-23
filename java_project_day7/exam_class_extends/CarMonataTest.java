package exam_class_extends;

/* [요구사항 2] 자동차 공장에서 Monata 자동차를 생산하려고 한다.
 * 아래의 실행 결과를 보고 색상/시리즈/용도별로 몇 대의 차량이 생산되어야 할지를 출력해 본다.
 * 다이어그램을 참조해서 클래스를 작성하고 실행결과와 같이 나올 수 있도록 구현하시오.
 */
class Car{
    private String color;
    private int account;

    public Car(String color, int account){
        this.color = color;
        this.account = account;
    }

    public String getColor(){ return color; }
    public int getAccount(){ return account; }

//    public String toString(){
//        return String.format("[색상] %-7s [생산수량] %-7d ",color,account);
//    }
    public String toString(){ return "[색상] " +color+"\t[생산수량] "+account+"\t";}
}

class Monata extends Car{
    private String series;
    private String use;

    public Monata(String color, int account, String series, String use){
        super(color, account);
        this.series = series;
        this.use = use;
    }

//    public String toString(){
//        return String.format(super.toString()+"[용도] %-7s [시리즈] %-7s ",series,use);
//    }
    public String toString(){ return super.toString()+"[용도] "+use+"\t[시리즈] "+series;}
}

public class CarMonataTest {
    public static void main(String[] args){
//        Monata m1 = new Monata("흰색", 5000, "승용", "NF");
//        Monata m2 = new Monata("은색", 7000, "업무","Brilliant");
//        Monata m3 = new Monata("감홍색", 4000, "택시","EF");
//        Monata m4 = new Monata("검정색", 6000, "승용","Hybrid");

        // 객체 배열
        Monata[] m = new Monata[]{
                new Monata("흰색", 5000, "승용", "NF"),
                new Monata("은색", 7000, "업무","Brilliant"),
                new Monata("감홍색", 4000, "택시","EF"),
                new Monata("검정색", 6000, "승용","Hybrid")
        };

        System.out.println("========================= Monata 생산 시작 =========================");
//        System.out.println(m1.toString());
//        System.out.println(m2.toString());
//        System.out.println(m3.toString());
//        System.out.println(m4.toString());

        // 향상for문
        for(Monata monata : m){
            System.out.println(monata.toString());
        }
        // 향상for문의 원리
        for(int i=0; i< m.length; i++){
            Monata monata = m[i];
            System.out.println(monata.toString());
        }
    }
}
