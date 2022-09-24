package simplephoneinfo;

import java.util.Scanner;

class PhoneBookManager{
    public static int j = PhoneBookVer03.i;
    public static Scanner scanner = PhoneBookVer03.scanner;
    public static void save(PhoneInfo[] pi){
        System.out.print("이름: ");
        pi[j].setName(scanner.nextLine());
        System.out.print("전화번호: ");
        pi[j].setPhoneNumber(scanner.nextLine());
        System.out.print("생년월일: ");
        pi[j].setBirthday(scanner.nextLine());

        System.out.print("데이터의 입력이 완료되었습니다.\n");

        pi[j] = new PhoneInfo(pi[j].getName(), pi[j].getPhoneNumber(), pi[j].getBirthday());
    }

    public static void search(PhoneInfo[] pi){
        name:
        do{
            System.out.println("데이터 검색을 시작합니다.");
            System.out.print("이름: ");
            String name = scanner.nextLine();
            for(j=0; j<pi.length; j++){
                if((pi[j].getName()).equals(name)){
                    pi[j].showPhoneInfo(); // 인스턴스 메서드의 사용
                    System.out.println("데이터의 검색이 완료되었습니다.");
                    break name;
                } else {
                    break;
                }
            }
            if(!(pi[j].getName()).equals(name)){
                System.out.println("원하시는 데이터를 찾지 못했습니다.");
                continue;
            }
        }while(true);
    }

    public static void delete(PhoneInfo[] pi){
        System.out.println("데이터 삭제를 시작합니다.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        for(j=0; j<pi.length; j++){
            if((name).equals(pi[j].getName())){
                PhoneInfo[] pi2 = new PhoneInfo[pi.length]; // 새로운 객체 참조변수 배열 생성
                for(int k=0; k<pi.length; k++)
                    pi2[k] = new PhoneInfo(); // 객체배열 생성 및 초기화
                for(int k=0; k<pi.length-1; k++){
                    if(k<j)
                        pi2[k] = pi[k];
                    else if(k==j)
                        continue;
                    else
                        pi2[k] = pi[k+1];
                }
                pi = pi2; // 참조변수로 새로운 배열 가리키게 한다
                System.out.println("데이터의 삭제가 완료되었습니다.");
                return;
            } else
                break;
        }
        System.out.println("원하시는 데이터를 찾지 못했습니다.");
    }
}

public class PhoneBookVer03 {
    public static int i = 0;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final int SIZE = 100;
        PhoneInfo[] pi = new PhoneInfo[SIZE];
        for(int i=0; i<SIZE; i++)
            pi[i] = new PhoneInfo(); // 객체배열의 참조변수 뿐 아니라 객체도 생성 및 초기화 해주어야 한다. 아니면 nullException 뜸

        do{
            System.out.println("선택하세요\n1. 데이터 입력\n2. 데이터 검색\n3. 데이터 삭제\n4. 프로그램 종료");
            System.out.print("선택> ");

            int choice = scanner.nextInt(); // 선택한 메뉴 번호 담을 변수

            switch(choice){
                case 1 :
                    scanner.nextLine();
                    PhoneBookManager.save(pi); // 메뉴 선택에서 2->1 누르면 ArrayIndexOutOfBoundsException 발생?
                    i++;
                    break;
                case 2 :
                    scanner.nextLine();
                    PhoneBookManager.search(pi);
                    break;
                case 3 :
                    scanner.nextLine();
                    PhoneBookManager.delete(pi);
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