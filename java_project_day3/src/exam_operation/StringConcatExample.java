package exam_operation;

public class StringConcatExample {
    public static void main(String[] args) {
        String str = "1"+"4"; // 문자열을 연결해주는 연결연산자
        String str1 = "JDK" + 17;
        String str2 = str1 + "버전";

        int num1 = Integer.parseInt("1") + Integer.parseInt("4"); // 문자열을 숫자로 바꿔주면 연산 가능
        System.out.println(num1);

        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);

        String str3 = "JDK" + 15 + 2.0;
        String str4 = 15 + 2.0 + "JDK";
        System.out.println(str3);
        System.out.println(str4);


    }
}
