package exam_while;

public class WhileExample {
    public static void main(String[] args){
        // 1부터 5까지 출력하기
        int i = 1;
        System.out.print("정수: ");
        while(i<=5){ // 1, 2, 3, 4 ,5
            System.out.print(i++ +", ");
        }
        System.out.println();

        i = 5;
        System.out.print("정수: ");
        while(true){ // 5, 4, 3, 2, 1
            System.out.print(i-- +", ");
            if(i<1){
                break; // 무한반복문에서는 반복문을 벗어나는 명령문 반드시 명시!
            }
        }
        System.out.println();

        // 1부터 100까지의 합 출력하기
        int num = 1, sum = 0;
        while(num<=100){
            sum += num++; // sum += num; 과 num++; 를 합한 문장
        }
        System.out.println("1부터 100까지의 합은 " + sum +" 입니다.");
    }
}
