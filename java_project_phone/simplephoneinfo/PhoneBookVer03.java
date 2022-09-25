package simplephoneinfo;

import java.util.Scanner;

class PhoneBookManager2{
    final int SIZE = 100;
    PhoneInfo[] pi = new PhoneInfo[SIZE];
    public static int i = 0;

    public static Scanner scanner = PhoneBookVer03.scanner;
    public void save(){
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String phoneNum = scanner.nextLine();
        System.out.print("생년월일: ");
        String birthday = scanner.nextLine();

        System.out.print("데이터의 입력이 완료되었습니다.\n");

        pi[i] = new PhoneInfo(name, phoneNum, birthday); // 객체도 생성 및 초기화. 아니면 nullException 뜸
        i++;
    }

    public void search(){
        System.out.println("데이터 검색을 시작합니다.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        for(int j=0; j<i; j++){ // nullPointerException나오는 이유는 입력한 값까지만 for문을 돌려야 하는데 100개를 돌렸기 때문
            if((pi[j].getName()).equals(name)){
                pi[j].showPhoneInfo(); // 인스턴스 메서드의 사용
                System.out.println("데이터의 검색이 완료되었습니다.");
                return;
            }
        }
        System.out.println("원하시는 데이터를 찾지 못했습니다.");
    }

    public void delete(){
        System.out.println("데이터 삭제를 시작합니다.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        for(int j=0; j<i; j++){
            if((name).equals(pi[j].getName())){
                for(int k=j; k<i-1; k++){
                    pi[k] = pi[k+1];
                }
                pi[i-1] = null;
                i--;
                System.out.println("데이터의 삭제가 완료되었습니다.");
                return;
            } else
                break;
        }
        System.out.println("원하시는 데이터를 찾지 못했습니다.");
    }
}

public class PhoneBookVer03 {

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        PhoneBookManager2 pm = new PhoneBookManager2();

        do{
            System.out.println("선택하세요\n1. 데이터 입력\n2. 데이터 검색\n3. 데이터 삭제\n4. 프로그램 종료");
            System.out.print("선택> ");

            int choice = scanner.nextInt(); // 선택한 메뉴 번호 담을 변수

            switch(choice){
                case 1 :
                    scanner.nextLine();
                    pm.save(); // 메뉴 선택에서 2->1 누르면 ArrayIndexOutOfBoundsException 발생?
                    break;
                case 2 :
                    scanner.nextLine();
                    pm.search();
                    break;
                case 3 :
                    scanner.nextLine();
                    pm.delete();
                    break;
                case 4 :
                    System.out.println("프로그램 종료");
                    scanner.close();
                    return;
                default :
                    System.out.println("잘못된 숫자를 입력하셨습니다.");
                    break;
            }
        }while(true);
    }
}
