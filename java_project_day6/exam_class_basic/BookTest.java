package exam_class_basic;

class Book {
    public int book_no; // 책번호
    public String book_name; // 책이름
    public String book_pub; // 출판사명
    public int book_pages; // 총페이지수

    public void display(){
        System.out.println("책번호: "+book_no+"\n책이름: "+book_name+"\n출판사명: "+book_pub+"\n총페이지수: "+book_pages);
    }

    public String toString(){
        return String.format("책번호: %s\n책이름: %s\n출판사명: %s\n총페이지수: %d\n", book_no, book_name, book_pub, book_pages);
    }


}


public class BookTest {
    public static void main(String[] args){
        Book b = new Book();
        b.book_no = 1;
        b.book_name = "미란다";
        b.book_pub = "민음사";
        b.book_pages = 150;
        b.display();
        System.out.println(b.toString());
    }
}
