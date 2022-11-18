package subject_management;

import academic_management.MenuViewer;

import java.util.ArrayList;

// 학과 입력, 수정, 삭제, 검색, 전체 조회 등의 실질적인 기능을 구현해놓은 클래스
public class SubjectManagement {
    private SubjectDAO dao = SubjectDAO.getInstance();

    public void read(String mode){
        SubjectVO vo = null;
        if(mode.equals("search")){
            vo = inputData("search");
            System.out.println("검색 단어 :"+vo.getS_name());
        }
        ArrayList<SubjectVO> svo = dao.getSubjectTotal(vo);
        System.out.println("\n**** subject 테이블 데이터 출력 ****");
        System.out.println("번호\t학과번호\t학과명");
        if(svo.size()>0){
//            for(int i=0; i<svo.size(); i++){
//                SubjectVO sub = svo.get(i);
            for(SubjectVO sub : svo){
                System.out.print(sub.getNo()+"\t"+sub.getS_num()+"\t"+sub.getS_name()+"\n");
            }
        } else {
            System.out.println("학과 정보가 존재하지 않습니다.");
        }
    }

    // 입력작업
    private SubjectVO inputData(String mode){ // 입력인지 수정인지 mode 받음
        String s_num = null, s_name = null;

        if(mode.equals("input")){
            System.out.print("학과코드 입력 : ");
            s_num = dao.getSubjectNum(); // 자동으로 학과번호 부여
            System.out.println(s_num);
        }

        if(!mode.equals("delete")){
            System.out.print("학과명 입력 : ");
            s_name = MenuViewer.keyboard.nextLine();
        }

        if(mode.equals("delete")){
            System.out.println("삭제 전 소속된 학생 여부를 확인하고자 학과 번호를 입력해주세요.");
            System.out.print("학과코드 입력 : ");
            s_num = MenuViewer.keyboard.nextLine();
        }

        SubjectVO sub = new SubjectVO(s_num,s_name);
        return sub;
    }

    // insert 작업
    public void create() {
        SubjectVO svo = inputData("input");
        if(dao.subjectInsert(svo))
            System.out.println("학과 데이터 입력 성공");
        else
            System.out.println("학과 데이터 입력 실패");
    }

    private int inputDataNo(){
        int no;
        System.out.print("일련번호 입력 : ");
        no = MenuViewer.keyboard.nextInt();
        return no;
    }

    public void update() {
        SubjectVO svo = inputData("update"); // 수정할 학과명
        int no = inputDataNo(); // 번호
        svo.setNo(no);

        if(dao.subjectUpdate(svo))
            System.out.println("학과 데이터 수정 성공");
        else
            System.out.println("학과 데이터 수정 실패");
    }

    public void delete() {
        SubjectVO svo = inputData("delete");
        int data = dao.studentDataCheck(svo);

        if(data!=0)
            System.out.println("소속된 학생이"+data+"명 존재함으로 학과데이터를 삭제할 수 없습니다");
        else {
            int no = inputDataNo();
            SubjectVO sv = new SubjectVO();
            sv.setNo(no);

            if(dao.subjectDelete(sv))
                System.out.println("학과 데이터 삭제 성공");
            else
                System.out.println("학과 데이터 삭제 실패");
        }
    }
}
