package exam_api_string.exam02_method;

public class StringExample {
    public static void main(String[] args) {
        String a = new String(" C#");
        String b = new String(",C++");

        System.out.println(a+"의 길이는 "+a.length()); // 문자열 길이(문자 개수). 공백 포함 길이 3
        System.out.println(a.contains("#")); // 문자열의 포함 관계

        a = a.concat(b); // 문자열 연결
        System.out.println(a);

        a = a.trim(); // 문자열 앞뒤 공백 제거
        System.out.println(a);

        a = a.replace("C#", "Java"); // 문자열 대체
        System.out.println(a);
        System.out.println();

        String s[] = a.split(","); // 문자열 분리
        for(int i=0; i<s.length; i++)
            System.out.println("분리된 문자열"+i+": "+s[i]);

        a = a.substring(5); // 인덱스 5부터 끝까지 반환
        System.out.println(a);

        char c = a.charAt(2); // 인덱스 2의 문자 반환
        System.out.println(c);

        String subject = "JAVA 프로그래밍";
        System.out.println(subject.indexOf("JAVA"));

        // 자바 관련 책인지 아닌지를 판별할 수 있도록 조건식 작성해주세요.
        if(subject.indexOf("JAVA")!=-1)
            System.out.println("자바와 관련된 책이군요.");
        else
            System.out.println("자바와 관련없는 책이군요.");

        String country = "한국,일본,중국,미국,독일,프랑스";

        // 지정된 구분자로 자른 후 문자열 배열 반환
        String[] list = country.split(",");

        // 분리하는 구분자, 분리하는 문자열의 개수(전체 문자열 개수는 3개로 한정)
        String[] list2 = country.split(",", 3);

        for(String item : list)
            System.out.println(item);
        System.out.println("==========================");
        for(String item : list2)
            System.out.println(item);
        System.out.println("==========================");

        String email = "purum@rubypaper.co.kr";
        // split() 메서드 사용하지 않고 출력되도록 코드 작성해주세요. id와 company 정의
        int i = email.indexOf("@");
        String id = email.substring(0,i);
        String company = email.substring(i+1,15);
        System.out.println(id);
        System.out.println(company);

        // 숫자 -> 문자열. 문자열 -> 숫자. 10 -> "10". "10" -> 10
        int number = 10;
        String value = String.valueOf(number);
        System.out.println(value);
        int value1 = Integer.valueOf(value);
        System.out.println(value1);
    }
}
