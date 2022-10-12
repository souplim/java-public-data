package exam_api_date;

import java.util.Calendar;

public class GoodMorning {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        System.out.println(today.getTime());
        if(4 <= today.get(Calendar.HOUR_OF_DAY) && today.get(Calendar.HOUR_OF_DAY) < 12)
            System.out.println("Good Moring");
        else if(today.get(Calendar.HOUR_OF_DAY) < 18)
            System.out.println("Good Afternoon");
        else if(today.get(Calendar.HOUR_OF_DAY) < 22)
            System.out.println("Good Evening");
        else
            System.out.println("Good Night");
    }
}
