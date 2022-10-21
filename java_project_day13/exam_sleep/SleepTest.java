package exam_sleep;

/* 다음과 같이 문자가 존재합니다.
 * Pride will have a fail.
 * Power is dangerous unless you have humility.
 * Office changes manners.
 * Empty vessels make the most sound.
 * 위 문자를 4초 간격으로 출력하도록 코드 작성하라
 * */
public class SleepTest {
    public static void main(String[] args) {
        String[] strs = {
                new String("Pride will have a fail."),
                new String("Power is dangerous unless you have humility."),
                new String("Office changes manners."),
                new String("Empty vessels make the most sound.")
        };

        for(int i=0; i<strs.length; i++){
            try {
                Thread.sleep(4000);
                System.out.println(strs[i]);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
