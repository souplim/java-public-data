package exam_api_math_random.exam01_math;

import java.util.Random;

public class MathExample {
    public static void main(String[] args) {
        int v1 = Math.abs(-5);
        double v2 = Math.abs(-3.14);
        System.out.println("v1(Math.abs)="+v1);
        System.out.println("v2(Math.abs)="+v2);

        double v3 = Math.ceil(5.13); // 매개변수 값을 올림함
        System.out.println("v3(Math.ceil)="+v3);

        double v4 = Math.floor(5.13); // 매개변수 값을 내림함
        System.out.println("v4(Math.floor)="+v4);

        int v5 = Math.max(5, 9); // 최댓값을 구함
        double v6 = Math.max(5.3, 2.5);
        System.out.println("v5(Math.max)="+v5);
        System.out.println("v6(Math.max)="+v6);

        int v7 = Math.min(5, 9); // 최솟값을 구함
        double v8 = Math.min(5.3, 2.5);
        System.out.println("v7(Math.min)="+v7);
        System.out.println("v8(Math.min)="+v8);

        long v9 = Math.round(5.3); // 소수점 첫째 자리에서 반올림함
        long v10 = Math.round(5.7);
        System.out.println("v9(Math.round)="+v9);
        System.out.println("v10(Math.round)="+v10);

        System.out.println(Math.random());
        int num = (int)(Math.random()*6)+1;
        System.out.println("주사위 눈: "+num);

        Random random = new Random();
        System.out.println("주사위 눈: "+(random.nextInt(6)+1));
        for(int i=0;i<6;i++)
            System.out.print((random.nextInt(6)+1)+" ");
    }
}
