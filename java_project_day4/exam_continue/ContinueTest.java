package exam_continue;


public class ContinueTest {
    public static void main(String[] args) {
        // 1~10까지의 수 중에서 홀수를 출력하도록 continue를 사용해보자
        int num = 0;
        do {
            num++;
            if(num%2==0){
                continue;
            }
            System.out.printf("%5d", num);
        } while(num<=10);
        System.out.println();

        // 1~10까지의 수 중에서 짝수를 출력하도록 continue를 사용해보자
        for(int i=1; i<=10; i++){
            if(i%2!=0){
                continue;
            }
            System.out.printf("%5d", i);
        }
    }
}
