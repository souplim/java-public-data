package exam_multi_type_parameter;

class Product<T, M> {
    private T kind; // 상품의 종류
    private M model; // 상품의 모델명

    public Product(){ }
    public Product(T kind, M model){
        this.kind = kind;
        this.model = model;
    }

    public T getKind(){ return this.kind; }
    public M getModel(){ return this.model; }
    public void setKind(T kind){ this.kind = kind; }
    public void setModel(M model){ this.model = model; }

    @Override // .getClass() 현재 실행중인 클래스 이름(패키지명.클래스명) .getSimpleName() 클래스명만 가져옴 .toUpperCase() 대문자로 변환
    public String toString(){
        return "kind : "+kind.getClass().getSimpleName().toUpperCase()+", model : "+model;
    }
}

class Car {
    private String color;

    public Car(){ }
    public Car(String color){ this.color = color; }

    public String getColor(){ return color; }
    public void setColor(String color){ this.color = color; }

    @Override
    public String toString(){
        return "[color : "+color+"]";
    }
}

class SmartPhone {
    private String company;
    private String os;

    public SmartPhone(){ }
    public SmartPhone(String company, String os){
        this.company = company;
        this.os = os;
    }

    public String getCompany(){ return company; }
    public void setCompany(String company){ this.company = company; }
    public String getOs(){ return os; }
    public void setOs(String os){ this.os = os; }

    @Override
    public String toString(){
        return "["+company+", "+os+"]";
    }
}

class TV {
    private int size;

    public TV(){ }
    public TV(int size){ this.size = size; }

    public int getSize(){ return size; }
    public void setSize(int size){ this.size = size; }

    @Override
    public String toString(){
        return "[size : "+size+"인치]";
    }
}

public class ProductExample {
    public static void main(String[] args) {
        Product<Car, String> product1 = new Product<>();
        product1.setKind(new Car());
        product1.getKind().setColor("RED"); // product1.getKind() -> 자동차의 주소값.setColor("color");
        product1.setModel("베뉴");
        System.out.println(product1.toString()+product1.getKind().toString());

        Product<TV, String> product2 = new Product<>(new TV(48), "스마트 TV");
        System.out.println(product2.toString()+product2.getKind().toString());

        Product<SmartPhone, String> product3 = new Product<>(new SmartPhone("삼성", "안드로이드"), "갤럭시 Z 플립3");
        System.out.println(product3.toString()+product3.getKind().toString());
        // product3 -> Product의 주소 product3.toString() -> Product의 toString()
        // product3.getKind() -> 스마트폰의 주소 product3.getKind().toString() -> 스마트폰의 toString()
    }
}
