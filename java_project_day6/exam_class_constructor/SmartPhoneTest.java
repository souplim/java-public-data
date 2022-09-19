package exam_class_constructor;

class SmartPhone {
    private String maker;
    private String name;
    private int price;
    private int discountRate;

    public SmartPhone(){ }
    public SmartPhone(String maker, String name, int price){
        this(maker, name, price, 0);
    }
    public SmartPhone(String maker, String name, int price, int discountRate){
        this.maker = maker;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
    }

    public int calculateDiscount(){
        return (int)(price*(1-(discountRate/100f)));
    }
    public String getMaker(){ return maker; }
    public void setMaker(String maker){ this.maker = maker; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public int getPrice(){ return price; }
    public void setPrice(int price){ this.price = price; }
    public int getDiscountRate(){ return discountRate; }
    public void setDiscountRate(int discountRate){ this.discountRate = discountRate; }

    public String toString(){
        return String.format("-------------------------------------\n%s [%s]\n가격 : %d\n할인가격(%d%%) : %d",name, maker, price, discountRate, calculateDiscount());
    }
}

public class SmartPhoneTest {
    public static void main(String[] args) {
        SmartPhone samsung = new SmartPhone("삼성","갤럭시노트9",1094500);
        samsung.calculateDiscount();
        SmartPhone apple = new SmartPhone("애플","아이폰XS",1364000, 10);
        apple.calculateDiscount();
        SmartPhone samsung2 = new SmartPhone("삼성","갤럭시S8",935000, 35);
        samsung2.calculateDiscount();

        System.out.println(samsung.toString()); // 할인가격 없을 때 안 나오게 하는 법?
        System.out.println(apple.toString());
        System.out.println(samsung2.toString());
    }
}
