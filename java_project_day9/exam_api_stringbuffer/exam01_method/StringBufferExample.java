package exam_api_stringbuffer.exam01_method;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This");

        sb.append(" is pencil"); // 문자열 덧붙이기
        System.out.println(sb);

        sb.insert(7, " my"); // 문자열 삽입
        System.out.println(sb);

        sb.replace(8, 10, "your"); // 문자열 대체
        System.out.println(sb);
    }
}
