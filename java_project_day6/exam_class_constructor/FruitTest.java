package exam_class_constructor;

/* 과일 정보를 가진 Fruit 클래스를 만든다.
 * 필드로는 과일명(fname), 가격(price)을 가진다. 필드 초기화를 위한 생성자, 설정자와 접근자가 필요합니다.
 * 총 구입액에서 15% 할인된 금액으로 구입한 과일주문내역을 출력해보자.
 * 실행 클래스는 별도로 생성하여 다음과 같이 결과가 나오도록 작성해 보자.*/
class Fruit {
    private String fname;
    private int price;

    public Fruit(){}
    public Fruit(String fname, int price){
        this.fname = fname;
        this.price = price;
    }

    public void setFname(String fname){ this.fname = fname; }
    public String getFname(){ return fname; }
    public void setPrice(int price){ this.price = price; }
    public int getPrice(){ return price; }

    public String toString(){
        return String.format(fname +":"+ price);
    }
}

public class FruitTest {
    public static void main(String[] args) {
        Fruit f1 = new Fruit("banana", 4800);
        Fruit f2 = new Fruit("strawberry", 21000);
        Fruit f3 = new Fruit("persimmon", 19000);
        Fruit f4 = new Fruit("cherry", 12000);

        int totalPrice = f1.getPrice()+f2.getPrice()+f3.getPrice()+f4.getPrice();
        int savePrice = (int)(totalPrice*0.15);

        System.out.println("==========과일구입 목록==========");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println("--------------------------------");
        System.out.println("총금액 : "+totalPrice);
        System.out.println("할인후 결제 금액 : "+(totalPrice-savePrice)+"원");

        // 객체배열로 코드 짜기
        Fruit[] f = new Fruit[]{
                new Fruit("banana", 4800),
                new Fruit("strawberry", 21000),
                new Fruit("persimmon", 19000),
                new Fruit("cherry", 12000)};

        int totalPrice2 = 0;
        int savePrice2 = 0;
        for(int i=0; i<f.length; i++){
            totalPrice2 += f[i].getPrice();
        }
        for(int i=0; i<f.length; i++){
            savePrice2 = (int)(totalPrice2*0.15);
        }
        System.out.println("==========과일구입 목록==========");
        for(int i=0; i<f.length; i++){
            System.out.println(f[i].toString());
        }
        System.out.println("--------------------------------");
        System.out.println("총금액 : "+totalPrice2);
        System.out.println("할인후 결제 금액 : "+(totalPrice2-savePrice2)+"원");
    }
}
