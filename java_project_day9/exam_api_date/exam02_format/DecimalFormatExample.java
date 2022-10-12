package exam_api_date.exam02_format;

import java.text.DecimalFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        double num = 1234567.482;

        print(num, "0.0"); // 1234567.5
        print(num, "0000000000.00000"); // 0001234567.48200
        print(num, "#.#"); //1234567.5
        print(num, "##########.#####"); // 1234567.482
        print(num, "####.00"); // 1234567.48
        print(num, "\u00A4 #,###"); // ₩ 1,234,567

        int num2 = 1289;
        print(num2, "#,###"); // 에러?
    }

    //Integer obj = Integer.valueOf(10); int i = obj.intValue() + 10;
    private static void print(Number number, String pattern){
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(number);
        if(number instanceof Double)
            System.out.printf("Number: %f, ",number);
        else
            System.out.printf("Number: %f, ",number);
        System.out.printf("Pattern: %-16s, result: %s\n", pattern, format);
    }
}
