package exam_api_stringbuffer.exam01_method;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("This");

        sb.append(" is pencil"); // 문자열 덧붙이기 This is pencil
        System.out.println(sb);

        sb.insert(7, " my"); // 문자열 삽입 This is my pencil
        System.out.println(sb);

        sb.replace(8, 10, "your"); // 문자열 대체 This is your pencil
        System.out.println(sb);

        sb.delete(8, 13); // This is pencil
        System.out.println(sb);

        sb.setLength(4); // 길이 변경 This
        System.out.println(sb);

        sb.reverse(); // sihT
        System.out.println(sb);

        sb.delete(0, sb.length());
        System.out.println(sb.toString().isEmpty()); // true
    }
}
