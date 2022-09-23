package simplephoneinfo;

import java.util.Scanner;

/*“프로그램 사용자로부터의 데이터 입력” 즉, 프로그램 사용자로부터 데이터를 입력 받아서 PhoneInfo클래스의 인스턴스를 생성한다.
프로그램 사용자가 종료 명령을 할 때까지 반복문을 사용하여 반복한다.
1. 키보드로부터 데이터 입력
2. 입력 받은 데이터로 PhoneInfo의 인스턴스 생성
3. 생성된 인스턴스의 showPhoneInfo 메소드 호출
그리고 실행 때마다 생성된 인스턴스는 유지되지 않아도 된다.
프로그램의 흐름을 계속할지 아니면 종료할지 프로그램 사용자가 선택할 수 있도록 해야 한다.
단 현재 예제에서는 사용자에게 이름, 전화번호, 생년월일을 입력 받도록 하자.*/
public class PhoneBookVer02 {
    public static Scanner scanner = new Scanner(System.in);

    public static void showMenu(){
        System.out.printf("선택하세요\n1. 데이터 입력\n2. 프로그램 종료\n선택 : ");
    }
    public static void readData(){
        System.out.print("이름 : ");
        String name = scanner.nextLine();
        System.out.print("전화번호 : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("생년월일 : ");
        String birthday = scanner.nextLine();

        PhoneInfo info = new PhoneInfo(name, phoneNumber, birthday);
        info.showPhoneInfo(); // 인스턴스 메서드의 사용
    }

    public static void main(String[] args) {
        // (3) 데이터 입력받아 출력
        int choice; // 데이터 입력과 종료 변수
        do{ showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // 입력받을 때 엔터 제거 구문

            switch(choice){
                case 1:
                    readData();
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
            }
        } while(true);
    }
}
