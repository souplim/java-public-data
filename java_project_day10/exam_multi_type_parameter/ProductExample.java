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

    @Override
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
    private String color;

    public TV(){ }
    public TV(String color){ this.color = color; }

    public String getColor(){ return color; }
    public void setColor(String color){ this.color = color; }

    @Override
    public String toString(){
        return "[color : "+color+"]";
    }
}

public class ProductExample {
}
