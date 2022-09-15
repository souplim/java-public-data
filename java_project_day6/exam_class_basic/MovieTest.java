package exam_class_basic;

class Movie {
    public String movieTitle;
    public int movieGrade;
    public String movieDirector;
    public int movieYear;

    public String toString(){
        return "movieTitle: "+movieTitle+", movieGrade: "+movieGrade+", movieDirector: "+movieDirector+", movieYear: "+movieYear;
    }
}

public class MovieTest {
    public static void main(String[] args) {
        Movie m = new Movie();
        System.out.println(m.toString());
        // 하나 값 
        // 사용자에게 값 입력받아 영화정보 출력
    }
}
package exam_class_basic;

import java.util.Scanner;

class Movie {
    public String movieTitle;
    public double movieGrade;
    public String movieDirector;
    public int movieYear;

    public String toString(){
        return "movieTitle: "+movieTitle+", movieGrade: "+movieGrade+", movieDirector: "+movieDirector+", movieYear: "+movieYear;
    }
}

public class MovieTest {
    public static void main(String[] args) {
        Movie m = new Movie();
        // 출력하기
        m.movieTitle = "안경";
        m.movieGrade = 3;
        m.movieDirector = "오기가미 나오코";
        m.movieYear = 2007;
        System.out.println(m.toString());

        // 사용자에게 값 입력받아 영화정보 출력
        Scanner scanner = new Scanner(System.in);
        System.out.print("원하는 영화의 제목을 입력하시오 : ");
        m.movieTitle = scanner.nextLine();
        System.out.print("해당 영화의 평점을 입력하시오 : ");
        m.movieGrade = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("해당 영화의 감족을 입력하시오 : ");
        m.movieDirector = scanner.nextLine();
        System.out.print("해당 영화의 개봉연도를 입력하시오 : ");
        m.movieYear = scanner.nextInt();
        System.out.println(m.toString());

    }
}
