package student_management;

import academic_management.MenuViewer;

// 학과 조회, 입력, 수정, 삭제, 검색 등의 실질적인 기능을 구현해놓은 클래스
public class StudentManagement {
    private StudentDAO dao = StudentDAO.getInstance(); // db 연동하여 작업하기 위한 인스턴스

    public void read(String mode){
        StudentVO vo = null; // 레코드 가져오기 위한 인스턴스
        if(mode.equals("search")){
//            vo = inputData("search");
            System.out.println("검생 이름 :"+vo.getSd_num());
        }
    }

    // 입력 작업
    public StudentVO inputData(String mode){
        String sd_num = null, sd_name = null, sd_id = null, sd_passwd = null, s_num = null, sd_birth = null, sd_phone = null, sd_address = null, sd_email = null;

        if(mode.equals("input")){
            System.out.print("학번 입력 : ");
            sd_num = dao.getStudentNum(); // 자동으로 학번 부여
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

        if(!mode.equals("delete")){ // 수정할 내용
            System.out.print("학번 입력 : ");
            sd_num = MenuViewer.keyboard.nextLine();
        }

        StudentVO sub = new StudentVO(sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email);
        return sub;
    }

    private int inputDataNo(){
        int sd_num;
        System.out.print("학번 입력 : "); // 해당 학번을 가진 학생의 정보 수정
        sd_num = MenuViewer.keyboard.nextInt();
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

        int no = inputDataNo(); // 번호
        svo.setNo(no);

        if(dao.studentUpdate(svo))
            System.out.println("학과 데이터 수정 성공");
        else
            System.out.println("학과 데이터 수정 실패");
    }
}
