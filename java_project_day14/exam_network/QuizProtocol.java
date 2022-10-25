package exam_network;

import java.io.IOException;
import java.net.ServerSocket;

class QuizProtocol {
    private static final int WAITING = 0;
    private static final int PROBLEM = 1;
    private static final int ANSWER = 2;

    private static final int NUMPROBLEMS = 3;

    private int state = WAITING;
    private int currentProblem = 0;

    private String[] problems = {"ㄱㅂ에 ㄷㅌㄹ","ㄴㄴ고 ㄱㅇㅈ도 ㅁㄹㄷ","ㄱㄹ싸움에 ㅅㅇ등 터진다." }; // 3개의 퀴즈문제를 작성해주세요.
    private String[] answers = {"개밥에 도토리","낫놓고 기역자도 모른다","고래싸움에 새우등 터진다"}; // 3개의 퀴즈에 대한 정답을 작성해주세요.

    public String process(String theInput){
        String theOutput = null;

        if(state == WAITING){
            theOutput = "퀴즈를 시작합니다(y/n)";
            state = PROBLEM;
        } else if(state == PROBLEM){
            if(theInput.equalsIgnoreCase("y")){
                theOutput = problems[currentProblem];
                state = ANSWER;
            } else {
                state = WAITING;
                theOutput = "quit";
            }
        } else if(state == ANSWER){
            if(theInput.equalsIgnoreCase(answers[currentProblem])){
                theOutput = "정답입니다. 계속하시겠습니까? (y/n)";
                state = PROBLEM;
            } else {
                theOutput = "오답입니다. 계속하시겠습니까? (y/n)";
            }
            currentProblem = (currentProblem+1)%NUMPROBLEMS; // 나머지. 번갈아가면서 나올 때 0,1,2만 반복
        }
        return theOutput;
    }
}
