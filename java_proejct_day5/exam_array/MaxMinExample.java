package exam_array;

// 다음의 정수 중에 12, 26, 68, 98, 76, 54 , 8, 6, 4 최대값, 최소값을 출력해주세요.
// [출력 결과] 최대값 : 00, 최소값: 00
public class MaxMinExample {
    public static void main(String[] args) {
        int[] array = {12, 26, 68, 98, 76, 54, 8, 6, 4};

        int max = array[0];
        int min = array[0];
        for(int i=1; i<array.length; i++){

            if(array[i]>=max){
                max = array[i];
            }

            if(array[i]<=min){
                min = array[i];
            }
        }

        System.out.printf("최대값 : %d, 최소값 : %d\n", max, min);
    }
}
