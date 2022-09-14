package example;

import java.util.Scanner;

// array 배열은 길이가 10인 1차원 배열로 아래와 같은 규칙을 가지고 있다.
// 두 수를 입력한 후, 입력한 수를 가지고 만든 array 배열을 출력하는 프로그램을 작성하세요
// [규칙] 10미만의 정수 두 개를 입력 받아서 첫번째 원소와 두번째 원소를 입력 받은 수로 초기화한다.
//       세번째 원소부터 마지막 원소까지는 전전항과 전항을 곱한 값의 1의 자리이다.
// [실행결과] 숫자 두 개를 입력해주세요: 3 4
//          [3, 4, 2, 8, 6, 8, 8, 4, 2, 8]
public class ArrayExample3 {
    public static void main(String[] args) {
        int[] array = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.print("10미만의 정수 두 개를 입력하시오 : ");
        array[0] = scanner.nextInt();
        array[1] = scanner.nextInt();

        if((array[0]<1 || 9<array[0]) || (array[1]<1 || 9<array[1])){
            System.out.println("정수는 1이상 10미만의 정수여야 합니다.");

        }
        for(int i=2; i<array.length; i++){
            array[i] = array[i-2]*array[i-1]%10;
        }

        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
