package example;

// 다음은 20명의 학생에게 학교 식당에 대한 만족도를 조사한 결과를 처리하는 프로그램이다.
// 학생들로 하여금 만족도를 3단계로 나누어 불만족(1), 보통(2), 만족(3)으로 응답하게 한 결과가 다음 표와 같을 때
// 만족도별 응답횟수를 출력하는 코드를 작성하시오.
// 실행결과-> 불만족:0, 보통:0, 만족:0
public class SchoolCafeteria {
    public static void main(String[] args) {
        int[] score = {1, 2, 1, 2, 3, 1, 2, 2, 3, 1, 3, 3, 1, 1, 1, 2, 3, 1, 3, 2};

        int satisfied=0;
        int normal=0;
        int notsatisfied=0;
        // 변수 세개 선언하지 않고 배열 사용해도 ok
//        int[] frequency = new int[3];

        for(int i=0; i<score.length; i++){
            if(score[i]==3){
                satisfied++;
//                frequency[2]++;
            } else if(score[i]==2){
                normal++;
            } else if(score[i]==1){ // else로 처리해도 되고 엄격하게 하려면 else if 사용
                notsatisfied++;
            }
        }
        System.out.printf("불만족:%d, 보통:%d, 만족:%d%n", notsatisfied, normal, satisfied);
    }
}
