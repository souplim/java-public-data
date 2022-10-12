package exam_api_date.exam01_date;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        // Wed Oct 12 14:09:08 KST 2022
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        // 2022년 10월 12일 수요일 오후 02시 09분 08초
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);

        // Calendar 클래스로 날짜 설정.
        Calendar today = Calendar.getInstance();
        // 2022년 10월 12일 수요일 오후 02시 09분 08초
        System.out.println(sdf.format(today.getTime()));

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//        Data date = sd.parse("2022-02-23"); // 문자열을 날짜형(Date)으로 변환
//        System.out.println(sd.format(date));

        // 10 -> "10"
        String data = String.valueOf(10);
        System.out.println("기초형 값을 문자열로 변화 : "+data);
        // "10" -> 10
        int number = Integer.parseInt(data);
        System.out.println("문자열 값을 기초형로 변화 : "+number);
    }
}
