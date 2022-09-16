package exam_class_basic;

import java.util.Scanner;

public class MovieTest {
    public static Scanner scanner = new Scanner(System.in); // 메인메소드 외에서도 사용할 수 있게 public으로 설정
    public static void main(String[] args) {
        // 1. 영화 정보를 직접 명시
        Movie m = new Movie();

        m.movieTitle = "안경";
        m.movieGrade = 3;
        m.movieDirector = "오기가미 나오코";
        m.movieYear = 2007;
        System.out.println(m.toString());

        Movie m2 = new Movie("킹메이커", 3, "변성현", 2020);
        System.out.println(m2.toString());


        // 2. 사용자에게 값 입력받아 영화정보 출력

        Movie m3 = new Movie();
        System.out.print("영화 제목 : ");
        m3.movieTitle = scanner.nextLine();
        System.out.print("영화 평점 : ");
        m3.movieGrade = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("영화 감독 : ");
        m3.movieDirector = scanner.nextLine();
        System.out.print("영화 개봉연도 : ");
        m3.movieYear = scanner.nextInt();
        System.out.println(m3.toString());


        // 사용자로 하여금 영화정보를 입력받기 위한 메서드를 별도로 구하여 설정
        Movie m4 = new Movie();
        inputData(m4);
        Movie m5 = new Movie();
        inputData(m5);

        System.out.println("영화 정보는 다음과 같다");
        System.out.println("========================================");
        System.out.println("제목\t\t평점\t\t감독\t\t개봉일");
        System.out.println("========================================");
        System.out.println(m4.toString());
        System.out.println(m5.toString());
    }

    // 데이터를 입력받기 위한 메서드
    public static void inputData(Movie mv) { // Movie mv = m4(참조값/주솟값)
        //필드에 직접 대입
        scanner.nextLine(); // 엔터를 입력값으로 받지 않기 위한 코드
        System.out.print("영화 제목 : ");
        mv.movieTitle = scanner.nextLine();
        System.out.print("영화 평점 : ");
        mv.movieGrade = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("영화 감독 : ");
        mv.movieDirector = scanner.nextLine();
        System.out.print("영화 개봉연도 : ");
        mv.movieYear = scanner.nextInt();
    }
}

class Movie {
    public String movieTitle; // 영화제목
    public double movieGrade; // 영화평점
    public String movieDirector; // 영화감독
    public int movieYear; // 개봉연도

    Movie(){ }
    Movie(String movieTitle, double movieGrade, String movieDirector, int movieYear){
        this.movieTitle = movieTitle;
        this.movieGrade = movieGrade;
        this.movieDirector = movieDirector;
        this.movieYear = movieYear;
    }

    public String toString(){
        return "movieTitle: "+movieTitle+", movieGrade: "+movieGrade+", movieDirector: "+movieDirector+", movieYear: "+movieYear;
//        return String.format("%s\t %s\t %-10s\t %s", movieTitle, movieGrade, movieDirector, movieYear);
    }
}
