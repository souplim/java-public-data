package exam_class;

import java.io.*;
import java.util.Arrays;

/* [요구사항] 랜덤 메서드나 랜덤 클래스 등을 이용하여 정수 10개(각자 임의의 수)를 문자열의 형태로 들어있는 파일(input.txt)을 생성한다.
 * 생성된 파일을 읽어서 오름차순으로 정렬한 다음 정렬된 숫자를 문자열의 형태로 파일(output.txt)에 쓰는 프로그램을 작성하라.
input.txt   ------------> output.txt
   127         10
   25         25
   10         127
   223      223
 */
public class FileExample {
    public static void main(String[] args) {

        final int NUM =10;
        String[] str = new String[NUM];

        try (PrintWriter pw = new PrintWriter((new FileWriter("input.txt")))){

            for(int i=0; i<NUM; i++)
                str[i] = (int)(Math.random()*100+1)+"";

            for(int i=0; i<NUM; i++)
                pw.println(str[i]);

        } catch (IOException io){
            io.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             PrintWriter pw = new PrintWriter((new FileWriter("output.txt")))) {

            String s = "";
            for(int i=0; i<NUM; i++){
                if ((s = br.readLine()) != null)
                    str[i] = s;
            }
            System.out.println();

            for(int j=NUM-1; j>0; j--) {
                for (int i = 0; i < j; i++) {
                    if (Integer.parseInt(str[i]) > Integer.parseInt(str[i + 1])) {
                        String tmp = str[i];
                        str[i] = str[i+1];
                        str[i+1] = tmp;
                    }
                }
            }

            for(int i=0; i<NUM; i++)
                pw.println(str[i]);

        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
