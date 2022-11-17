package academic_management;

import subject_management.SubjectManagement;

// 실행 클래스
public class AcademicManagement {
    public static void main(String[] args) {
        SubjectManagement subject = new SubjectManagement();
        int topMenuChoice, subMenuChoice;

        System.out.println("학사 관리 프로그램을 시작합니다");
        while(true){
            MenuViewer.showTopMenu();
            topMenuChoice = MenuViewer.keyboard.nextInt();
            MenuViewer.keyboard.nextLine();

            if(topMenuChoice<1 || topMenuChoice>3){
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
                continue;
            }

            if(topMenuChoice == 3){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }

            MenuViewer.showSubMenu();
            subMenuChoice = MenuViewer.keyboard.nextInt();
            MenuViewer.keyboard.nextLine();

            if(topMenuChoice == 1){
                switch(subMenuChoice){
                    case 1:
                        subject.read();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default :
                        System.out.println("검색, 입력, 수정, 삭제, 검색 중에 하나를 선택해주세요");
                }
            } else if (topMenuChoice == 2){
                System.out.println("준비중");
            }
        }

    }
}
