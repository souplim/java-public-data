package exam_lambda;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> day = () -> new SimpleDateFormat("E요일").format(new Date());
        String result = day.get();
        System.out.println(result);
    }
}
