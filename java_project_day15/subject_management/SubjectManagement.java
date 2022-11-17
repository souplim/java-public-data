package subject_management;

import java.util.ArrayList;

// 학과 입력, 수정, 삭제, 검색, 전체 조회 등의 실질적인 기능을 구현해놓은 클래스
public class SubjectManagement {
    private SubjectDAO dao = SubjectDAO.getInstance();

    public void read(){
        ArrayList<SubjectVO> svo = dao.getSubjectTotal();
        System.out.println("\n**** subject 테이블 데이터 출력 ****");
        System.out.println("번호\t학과번호\t학과명");
        if(svo.size()>0){
            for(SubjectVO sub : svo){
                System.out.print(sub.getNo()+"\t"+sub.getS_num()+"\t"+sub.getS_name()+"\n");
            }
        } else {
            System.out.println("학과 정보가 존재하지 않습니다.");
        }
    }
}
