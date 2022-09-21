package exam_class_constructor;

/*스마트폰을 구입하려고 한다. SmartPhone 클래스의 생성자를 이용하여 객체를 생성하고 모든 종류와 할인 정보를 출력한다.
아래 UML을 기준으로 SmartPhone 클래스를 생성하자.
각 멤버 변수(필드)는 제조사 maker, 명칭 name, 가격 price, 할인율 discountRate로 지정한다.
생성자, 설정자, 접근자 등을 작성해 주면 된다.
실행 클래스 내에 main() 메서드를 실행하여 다음과 같은 결과가 나올 수 있도록 구현하시오.*/
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

    // UML에 toString 메서드 없음. 실행클래스에서 직접 출력으로 짜기
//    public String toString(){
//        return String.format("-----------------------------\n%s [%s]\n가격 : %d\n할인가격(%d%%) : %d",name, maker, price, discountRate, calculateDiscount());
//    }
}

public class SmartPhoneTest {
    public static void main(String[] args) {
//        SmartPhone samsung = new SmartPhone("삼성","갤럭시노트9",1094500);
//        samsung.calculateDiscount();
//        SmartPhone apple = new SmartPhone("애플","아이폰XS",1364000, 10);
//        apple.calculateDiscount();
//        SmartPhone samsung2 = new SmartPhone("삼성","갤럭시S8",935000, 35);
//        samsung2.calculateDiscount();

        // 객체 배열
        SmartPhone[] samsung = new SmartPhone[]{
                new SmartPhone("삼성","갤럭시노트9",1094500),
                new SmartPhone("애플","아이폰XS",1364000, 10),
                new SmartPhone("삼성","갤럭시S8",935000, 35)
        };

        for(int i=0; i<samsung.length; i++){
            samsung[i].calculateDiscount();
        }

        System.out.println("===========제품목록===========");
        for(int i=0; i<samsung.length; i++){
            System.out.println(samsung[i].getName()+" ["+samsung[i].getMaker()+"]");
            System.out.println("가격 : "+samsung[i].getPrice());
            if(samsung[i].getDiscountRate()!=0)
                System.out.println("할인가격("+samsung[i].getDiscountRate()+"%) : "+samsung[i].calculateDiscount());
        }

//        System.out.println(samsung.toString()); // 할인가격 없을 때 안 나오게 하는 법?
//        System.out.println(apple.toString());
//        System.out.println(samsung2.toString());
    }
}
