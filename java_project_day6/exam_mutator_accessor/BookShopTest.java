package exam_class_basic;

/* 책을 관리하는 BookShop 클래스를 만든다.
 * 클래스는 책제목(title), 저자(author), 책 가격(price)을 필드로 가진다.
 * 각 필드에 설정자와 접근자를 생성한다.
 * 그리고 필드에 값을 대입하기 위한 메서드도 생성한다.
 */
class BookShop {
    private String title;
    private String author;
    private int price;

    public void setTitle(String title){ this.title = title; }
    public String getTitle(){ return title; }
    public void setAuthor(String author){ this.author = author; }
    public String getAuthor(){ return author; }
    public void setPrice(int price){ this.price = price; }
    public int getPrice(){ return price; }

    public void bookShopData(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String toString(){
        return String.format("책이름: %s\n저자: %s\n가격: %d", title, author, price);
    }
}

public class BookShopTest {
    public static void main(String[] args){
        BookShop bs = new BookShop();

        System.out.println("\n<<값 대입>>");
        bs.bookShopData("안드로이드 이렇게 시작하세요", "홍길동", 30000);

        System.out.println("책이름 : "+bs.getTitle());
        System.out.println("저자 : "+bs.getAuthor());
        System.out.println("가격 : "+bs.getPrice());

        System.out.println("\n<<값 변경 후 출력>>");
        bs.setTitle("CODE");
        bs.setTitle("찰스 펫졸드");
        bs.setPrice(32000);

        System.out.println(bs.toString());

    }
}
