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
