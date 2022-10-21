package exam_sleep;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SleepTest01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        SimpleDateFormat DF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        long start = System.currentTimeMillis();
        for(int x : list){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(DF.format(new Date()) +" : " + x);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"ms");
    }
}
