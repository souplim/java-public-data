package exam_array_in_array;

// 성적 프로그램을 작성해보자.
/* 다음의 이름으로 정의한다. 학생명: name / 점수: score / 평균: avg / 학점: grade / 재수강: pass / 순위: rank
 * 수식은 다음과 같다. 총점 = 국어 + 영어 + 수학; 평균 = 총점/3;
 * 학점 = 평균 90이상 'A'/80이상 'B'/70이상 'C'/60이상 'D'/나머지는 'F'
 * 재수강 = 평균 60이상이면 'pass' / 60미만이면 'nopass'
 * 순위 구하기는 제일 마지막에 작성한다.
 * 2차원 배열과 1차원 배열을 이용하여 위의 문제를 해결해주세요.
* */
public class GradesProgramming {
    public static void main(String[] args) {
        String[] name = {"홍길동", "김철수", "이진희"};
        int[][] score = { {90, 75, 61},
                          {55, 56, 46},
                          {90, 90, 90}};
        int[] total = new int[3];
        double[] avg = new double[3];
        char[] grade = new char[3];
        String[] pass = new String[3];
        int[] rank = new int[3];

        // 총합
        for(int i=0; i<score.length; i++){
            for(int j=0; j<score[i].length; j++){
                total[i] += score[i][j];
            }
        }
        // 평균
        for(int i=0; i<score.length; i++){
            avg[i] = (float)total[i]/score.length;
        }
        // 학점
        for(int i=0; i<score.length; i++){
            if(avg[i]>=90){
                grade[i] = 'A';
            } else if(avg[i]>=80){
                grade[i] = 'B';
            } else if(avg[i]>=70){
                grade[i] = 'C';
            } else if(avg[i]>=60){
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }
        // 재수강
        for(int i=0; i<score.length; i++){
            if(avg[i]>=60){
                pass[i] = "pass";
            } else {
                pass[i] = "nopass";;
            }
        }
        // 순위 ?
        if(avg[0]>=avg[1]){
            if(avg[0]>=avg[2]){
                rank[0] = 1;
                if(avg[1]>=avg[2]){
                    rank[1] = 2;
                    rank[2] = 3;
                } else {
                    rank[2] = 2;
                    rank[1] = 3;
                }
            } else if(avg[2]>=avg[1]) {
                rank[2] = 1;
                rank[0] = 2;
                rank[1] = 3;
            }
        } else if(avg[1]>=avg[0]) {
            if(avg[1]>=avg[2]){
                rank[1] = 1;
                if(avg[0]>=avg[2]){
                    rank[0] = 2;
                    rank[2] = 3;
                } else {
                    rank[2] = 2;
                    rank[0] = 3;
                }
            } else if(avg[2]>=avg[1]){
                rank[2] = 1;
                rank[1] = 2;
                rank[3] = 3;
            }
        }

        System.out.println("                  성적 프로그램                 ");
        System.out.println("===============================================");
        System.out.println("번호 이름  국어 영어 수학 총점  평균  학점 재수강 순위");
        for(int i=0; i<score.length; i++){
            System.out.printf("%d  %s  %d   %d  %d  %d  %.2f  %c  %7s  %d\n" , i+1, name[i], score[i][0], score[i][1], score[i][2], total[i], avg[i], grade[i], pass[i], rank[i]);
        }

    }
}
