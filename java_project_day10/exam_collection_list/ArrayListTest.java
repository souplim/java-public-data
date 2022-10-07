package exam_collection_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        // 프로그래밍 언어(문자열)를 저장하도록 인스턴스 생성
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Java");
        list.add("JSP");
        list.add("SPRING");

        int size = list.size();
        System.out.println("총 객체 수: "+size);
        System.out.println();

        list.add(1, "ORACLE");
        list.set(2, "Client programming");
        list.remove(3);

        int index = list.indexOf("Java");
        System.out.println(index);

        index = list.lastIndexOf("Java");
        System.out.println(index);

        // 출력 방법 1. for문
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
        // 출력 방법 2. 향상for문(for~each문)
        for(String str : list)
            System.out.println(str);
        System.out.println();

        // 정수값을 저장하도록 인스턴스 생성
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(23);
        list1.add(Integer.valueOf(94));
        list1.add(Integer.valueOf(62));
        list1.add(Integer.valueOf(45));

        System.out.println(list1); // 반복문 통하지 않고 모든 원소를 문자열로 출력 가능(toString()에서 지정한 대로)
//        System.out.println(list1.toString());

        list1.add(2, Integer.valueOf(78));
        System.out.println(list1.toString());
        System.out.println();

        // Apple 이라는 이름으로 클래스를 생성한다. 이 클래스는 품종(kind)과 색상(color)을 필드로 가진다.
        // 여러 사과(Apple)를 저장하도록 인스턴스 생성하여 출력해 주세요.
        ArrayList<Apple> list2 = new ArrayList<Apple>();
        list2.add(new Apple("부사", "빨강"));
        list2.add(new Apple("아오리", "청색"));
        list2.add(new Apple("썸머킹", "황금"));
        list2.add(new Apple("홍로", "빨강"));

        // 출력 - 1
        for(int i=0; i<list2.size(); i++){
            Apple apple = list2.get(i); // Apple의 주소 가져오는 것이므로 타입은 Apple
            System.out.println("품종: "+ apple.getKind()+", 색상: "+ apple.getColor());
        }
        System.out.println();

        // 출력 - 2
        for(int i=0; i<list2.size(); i++)
            System.out.println(list2.get(i));
        System.out.println();

        // 출력 -3
        for(Apple apple : list2)
            System.out.println(apple);
        System.out.println();

        printArray(list2);
        System.out.println();


        // 여러 영화(Movie) 정보를  저장하도록 인스턴스 생성
        // Movie 클래스는 영화제목(mTitle), 평점(mGrade), 감독(mDirector), 개봉일(anYear) 등의 필드를 가진다.
        //인터페이스명<타입 인자> 참조변수 = new 구현클래스 생성자<타입 인자>();
        List<Movie> list3 = new ArrayList<Movie>();
        list3.add(new Movie("더 배트맨","★★★★☆ 8.78","맷 리브스","2022개봉"));
        list3.add(new Movie("다크 나이트 라이즈","★★★★★ 9.02","론 하워드","2020재개봉"));
        list3.add(new Movie("해적","★★★☆☆ 6.41","김정훈","2022개봉"));

        Movie m = new Movie();
        m.setTitle("어메이징 그레이스");
        m.setGrade("★★★★☆ 8.62");
        m.setDirector("시드니 폴락, 알란 엘리어트");
        m.setYear("2019 개봉");
        list3.add(m);

        // 원소의 개수로 인덱스 접근
        for(int i=0; i<list3.size(); i++)
            System.out.println(list3.get(i));
        System.out.println();

        // for~each: for(자료형 변수 : 배열이나 컬렉션)
        for(Movie movie : list3) // list3 정보 타입이 Moive 변수명이 movie
            System.out.println(movie); // movie를 순차적으로 출력
        System.out.println();

        // 반복자
        Iterator<Movie> it = list3.iterator(); // 정보에 접근할 반복자의 주소 가져옴
        while(it.hasNext())
            System.out.println(it.next());
    }

    public static void printArray(ArrayList<Apple> list){
        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
    }
}

class Apple {
    private String kind;
    private String color;

    public Apple(String kind, String color){
        this.kind = kind;
        this.color = color;
    }

    public String getKind(){ return kind; }
    public void setKind(String kind){ this.kind = kind; }
    public String getColor(){ return color; }
    public void setColor(String color){ this.color = color; }

    @Override
    public String toString(){
        return "품종: "+kind+", 색상: "+color;
    }
}

class Movie {
    private String mTitle;
    private String mGrade;
    private String mDirector;
    private String anYear;

    Movie(){}
    Movie(String mTitle, String mGrade, String mDirector, String anYear){
        this.mTitle =mTitle;
        this.mGrade = mGrade;
        this.mDirector = mDirector;
        this.anYear = anYear;
    }

    public void setTitle(String mTitle){ this.mTitle = mTitle; }
    public void setGrade(String mGrade){ this.mGrade = mGrade; }
    public void setDirector(String mDirector){ this.mDirector = mDirector; }
    public void setYear(String anYear){ this.anYear = anYear; }

    @Override
    public String toString(){
        return String.format("title: %s grade: %s director: %s year: %s",mTitle,mGrade,mDirector,anYear);
    }
}