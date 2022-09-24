package exam_class_constructor;

/* 다음과 같이 주어진 데이터를 이용해서 ScoreOX 클래스를 통해서 실행결과와 같이 나올 수 있도록 구현하시오.
 * 번호(no), 이름(name), 1~5번의 입력 답(dap[]), 답의 개수를 체크하는 cnt를 이용하여 점수(score)를 매기고 맞는 전체 개수를 체크하는 static 변수인 tot를 이용한다.
 * 또한 생성자를 이용하여 번호, 이름, 답을 받아 객체를 생성하고
 * compute() 메서드에서는 정답{1,1,1,1,1}과 입력한 데이터가 맞으면 개수와 전체 개수를 체크하여 display() 메서드로 각 내용을 출력한다.
 * 마지막으로 static 메서드인 ranking() 메서드에서는 5명의 ScoreOX의 객체를 배열로 받아 순위를 구한다.
 */
class ScoreOX {
    private int no; // 번호
    private String name; // 이름
    private int[] dap; // 1~5의 입력 답
    private int cnt; // 체크한 답의 개수
    private int score; // 개별 점수
    public int rank;
    private char[] c_ox; // 문제 O,X 표시
    public static int tot = 0; // 전체 맞은 개수

    public ScoreOX(){ }
    public ScoreOX(int no, String name, int[] dap){
        this.no = no;
        this.name = name;
        this.dap = dap;
    }

    int[] answer = new int[]{1, 1, 1, 1, 1};

    public void compute(){
        cnt = 0;
        for(int i=0; i<answer.length; i++){
            if(answer[i]==dap[i]){
                cnt++;
            }
        }
        score = cnt*20;
        ScoreOX.tot += cnt;
    }

    public void display(){
        System.out.print(no+"\t");
        System.out.print(name+"\t");
        c_ox = new char[answer.length];
        for(int i=0; i<c_ox.length; i++){
            if(answer[i]==dap[i])
                c_ox[i] = 'o';
            else
                c_ox[i] = 'x';
            System.out.print(c_ox[i]+"   ");
        }
        System.out.print(score);
    }

    public static void ranking(ScoreOX[] sc){
        // 순위 알고리즘
        for(int i=0; i<sc.length; i++){
            for(int j=0; j<sc.length; j++) // 순위 초기화
                sc[i].rank = 1;
            for(int j=0; j<sc.length; j++){
                if(sc[i].score<sc[j].score)
                    sc[i].rank++;
            }
        }
    }
}

public class ScoreOXMain {
    public static void main(String[] args) {
        // 객체 배열 생성
        ScoreOX[] sc = new ScoreOX[]{
                new ScoreOX(1, "홍길동", new int[]{1, 2, 1, 3, 4}),
                new ScoreOX(2, "김철수", new int[]{1, 1, 1, 1, 1}),
                new ScoreOX(3, "이진희", new int[]{1, 2, 1, 3, 1}),
                new ScoreOX(4, "조현민", new int[]{1, 1, 1, 3, 1}),
                new ScoreOX(5, "최현정", new int[]{1, 4, 2, 5, 4})
        };

        for(int i=0; i<sc.length; i++){
            sc[i].compute();
            ScoreOX.ranking(sc);
        }

        System.out.println(" * * 시험결과 * *");
        System.out.println("---------------------------------------");
        System.out.println("번호\t 이름 \t1\t2\t3\t4\t5\t점수\t등수");
        System.out.println("---------------------------------------");
        for(int i=0; i<sc.length; i++){
            sc[i].display();
            System.out.print(" "+sc[i].rank);
            System.out.println();
        }
        System.out.println();
        System.out.println("전체맞은 개수 = "+ScoreOX.tot);
    }
}
