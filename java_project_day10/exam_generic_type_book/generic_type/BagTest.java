package exam_generic_type_book.generic_type;

// 제네릭 클래스
class Bag<T> {
    private T thing;
    // 생성자
    public Bag(T thing){ this.thing = thing; }
    public T getThing(){ return thing; }
    public void setThing(T thing){this.thing = thing; }
    // .getClass().getSimpleName() 현재 실행중인 클래스의 이름만 가져와라(패키지 빼고)
    void showType(){ System.out.println("T의 타입은 "+thing.getClass().getSimpleName()); }
}

class Book {
    private String title;
    private String writer;

    public Book(){ }
    public Book(String title, String writer){
        this.title = title;
        this.writer = writer;
    }
    @Override
    public String toString(){
        return "Book [title="+title+",writer="+writer+"]";
    }
}

class PencilCase {
    private String brand;
    private String kind;

    public PencilCase(){ }
    public PencilCase(String brand, String kind){
        this.brand = brand;
        this.kind = kind;
    }
    @Override
    public String toString(){
        return "PencilCase [brand="+brand+",kind="+kind+"]";
    }
}

class Notebook {
    private String make;
    private String size;

    public Notebook(){ }
    public Notebook(String make, String size){
        this.make = make;
        this.size = size;
    }
    @Override
    public String toString(){
        return "Notebook [make="+make+",size="+size+"]";
    }
}

public class BagTest {
    public static void main(String[] args) {
        Bag<Book> bag = new Bag<>(new Book("마음의 세탁소","황용근"));
        Bag<PencilCase> bag2 = new Bag<>(new PencilCase("룬룬필통","시크그레이"));
        Bag<Notebook> bag3 = new Bag<>(new Notebook("모닝글로리","A4"));

        bag.showType();
        bag2.showType();
        bag3.showType();

//        bag = bag2; 타입이 달라 불가능
        System.out.println(bag.getThing().toString()); // 책의 인스턴스 주소 전달
        System.out.println(bag.getThing());
        System.out.println(bag2.getThing().toString()); // 필통의 인스턴스 주소 전달
        System.out.println(bag3.getThing().toString()); // 공책의 인스턴스 주소 전달
    }
}
