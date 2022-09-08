package exam_dowhile;

public class DoWhileExample {
    public static void main(String[] args) {
        int num = 0;
        do {
            System.out.println("num의 값: "+ num);
            num++;
        } while(num<0); // while(false)일 때 do-while문 빠져나감

        System.out.println();

        // 1에서부터 10까지 출력
        int i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while(i <= 10);

        System.out.println();

        // 10에서부터 1까지 출력
        i = 10;
        do {
            System.out.print(i + " ");
            i--;
        } while (i >= 1);
    }
}
