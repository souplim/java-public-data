package student_management;

import academic_management.MenuViewer;
import subject_management.SubjectVO;

import java.util.ArrayList;

// 학과 조회, 입력, 수정, 삭제, 검색 등의 실질적인 기능을 구현해놓은 클래스
public class StudentManagement {
    private StudentDAO dao = StudentDAO.getInstance(); // db 연동하여 작업하기 위한 인스턴스

    public void read(String mode){
        StudentVO vo = null; // 레코드 가져오기 위한 인스턴스
        if(mode.equals("search")){
            vo = inputData("search");
            System.out.println("검색 학번 : "+vo.getSd_num());
        }
        ArrayList<StudentVO> svo = dao.getStudentTotal(vo);

        System.out.println("\n**** student 테이블 데이터 출력 ****");
        System.out.println("번호\t학번\t이름\t아이디\t패스워드\t학과번호\t생년월일\t핸드폰번호\t주소\t이메일주소\t등록일자");
        if(svo.size()>0){
//            for(int i=0; i<svo.size(); i++){
//                StudentVO stu = svo.get(i);
            for(StudentVO stu : svo)
                System.out.print(stu.getNo()+"\t"+stu.getSd_num()+"\t"+stu.getSd_name()+"\t"+stu.getSd_id()+"\t"+stu.getSd_passwd()+"\t"+stu.getS_num()+"\t"+stu.getSd_birth()+"\t"+stu.getSd_phone()+"\t"+stu.getSd_address()+"\t"+stu.getSd_email()+"\t"+stu.getSd_date()+"\n");
        } else {
            System.out.println("학생 정보가 존재하지 않습니다.");
        }
    }

    // 입력 작업
    public StudentVO inputData(String mode){
        String sd_num = null, sd_name = null, sd_id = null, sd_passwd = null, s_num = null, sd_birth = null, sd_phone = null, sd_address = null, sd_email = null;

        if(mode.equals("input")){
            System.out.print("학과코드 입력 : ");
            s_num = MenuViewer.keyboard.nextLine();
            StudentVO s = new StudentVO(sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email);
            sd_num = dao.getStudentNum(s);
            System.out.println(sd_num);

            System.out.print("이름 입력 : ");
            sd_name = MenuViewer.keyboard.nextLine();
            System.out.print("아이디 입력 : ");
            sd_id = MenuViewer.keyboard.nextLine();
            System.out.print("패스워드 입력 : ");
            sd_passwd = MenuViewer.keyboard.nextLine();
            System.out.print("학과번호 입력 : ");
            s_num = MenuViewer.keyboard.nextLine();
            System.out.print("생년월일 입력 : ");
            sd_birth = MenuViewer.keyboard.nextLine();
            System.out.print("핸드폰 번호 입력 : ");
            sd_phone = MenuViewer.keyboard.nextLine();
            System.out.print("주소 입력 : ");
            sd_address = MenuViewer.keyboard.nextLine();
            System.out.print("이메일 주소 입력 : ");
            sd_email = MenuViewer.keyboard.nextLine();

        }

        if(mode.equals("search")){
            System.out.print("학번 입력 : ");
            sd_num = MenuViewer.keyboard.nextLine();
        }

        if(mode.equals("delete")){
            System.out.println("삭제할 학생의 학번을 입력해주세요.");
            System.out.print("학번 : ");
            sd_num = MenuViewer.keyboard.nextLine();
        }
        StudentVO stu = new StudentVO(sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email);
        return stu;
    }

    private String inputDataNum(){
        String sd_num;
        System.out.print("학번 입력 : "); // 해당 학번을 가진 학생의 정보 수정
        sd_num = MenuViewer.keyboard.nextLine();
        return sd_num;
    }

    public void create() {
        StudentVO svo = inputData("input");
        if(dao.studentInsert(svo))
            System.out.println("학생 데이터 입력 성공");
        else
            System.out.println("학생 데이터 입력 실패");
    }

    public void update() {
        StudentVO svo = inputData("update");

        String sd_num = inputDataNum(); // 학번 받아서 그 학번 학생 정보를 수정하게 함
        svo.setSd_num(sd_num);

        if(dao.studentUpdate(svo))
            System.out.println("학과 데이터 수정 성공");
        else
            System.out.println("학과 데이터 수정 실패");
    }

    public void delete() {
        StudentVO svo = inputData("delete");

        String sd_num = inputDataNum();
        StudentVO sv = new StudentVO();
        sv.setSd_num(sd_num);

        if(dao.studentDelete(sv))
            System.out.println("학과 데이터 삭제 성공");
        else
            System.out.println("학과 데이터 삭제 실패");
    }
}
