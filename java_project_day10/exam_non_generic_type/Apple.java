package exam_non_generic_type;

public class Apple{
    private String color;
    public Apple(String color){
        this.color = color;
    }
    public void set(String color){ this.color = color; }
    public String get(){ return color; }

    @Override
    public String toString(){ // Object의 toString() 메서드
        return "Apple [color : "+color+"]";
    }
}