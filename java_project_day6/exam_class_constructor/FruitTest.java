package exam_class_constructor;

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

        System.out.println("==========과일구입 목록==========");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());
        System.out.println(f4.toString());
        System.out.println("--------------------------------");
        System.out.println("총금액 : "+(int)(f1.getPrice()+f2.getPrice()+f3.getPrice()+f4.getPrice()));
        System.out.println("할인후 결제 금액 : "+(int)((f1.getPrice()+f2.getPrice()+f3.getPrice()+f4.getPrice())*0.85));
    }
}
