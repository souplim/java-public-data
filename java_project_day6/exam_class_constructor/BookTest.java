package exam_class_constructor;

class Book {
    String title;
    String author;

    // 각 필드의 값을 null이 아닌 ""빈문자로 초기화 -> Q.어떤 효과? null값으로 안 나오는?
    public Book(){
        this("", "");
    }
    public Book(String title){
        this(title, "작자미상"); // 매개변수 두개인 생성자가 호출되기 때문에 "매개변수가 두개인 생성자" 한번 더 출력됨
        System.out.print("매개변수가 하나인 생성자\n");
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        System.out.print("매개변수가 두개인 생성자\n");
    }

    public String toString(){
        return "책제목 : " + title + " 책저자 : " + author;
    }
}
public class BookTest {
    public static void main(String[] args) {
        Book littlePrince = new Book("어린왕자", "생텍쥐페리");
        Book loveStory = new Book("춘향전");
        Book b1 = new Book();

        // 핃드(인스턴스변수)가 default이기 때문에 같은 패키지 내에서는 직접접근해서 값 가져올 수 있음
        System.out.println(littlePrince.title+" "+littlePrince.author);
        System.out.println(loveStory.title+" "+loveStory.author);

        System.out.println(littlePrince.toString());
        System.out.println(loveStory.toString());
        System.out.println(b1.toString());
    }
}
