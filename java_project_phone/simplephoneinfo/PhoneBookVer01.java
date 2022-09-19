package simplephoneinfo;

/*  클래스에는 데이터들이 문자열의 형태로 저장 가능해야 하며, 저장된 데이터의 출력이 가능하도록 메소드도 정의한다.
 *  단, 생년월일 정보는 저장할 수도, 저장하지 않을 수도 있게 생성자를 정의한다.
 *
 * 필드는 private 선언
 * 설정자(Setter) / 접근자(Getter)
 * 생성자
 * 출력은 toString()이 아니라 showPhoneInfo()로 설정 Q.WHY? A. 반환값 없이 바로 출력하는 메서드
 * [실행 예시]
 * name: 임미경
 * phone: 010-2345-8745
 * birth: 1965.03.28.
 */

import java.util.Scanner;

class PhoneInfo {
    private String name;
    private String phoneNumber;
    private String birthday;

    PhoneInfo(){ }
    PhoneInfo(String name, String phoneNumber){
        this(name, phoneNumber, "");
    }
    PhoneInfo(String name, String phoneNumber, String birthday){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return birthday;
    }

    public void showPhoneInfo(){
        System.out.printf("name: %s\nphone: %s\nbirthday%s\n", name, phoneNumber, birthday);
    }
}

public class PhoneBookVer01 {
    public static Scanner scanner = new Scanner(System.in);
    public static void inputPhoneinfo(PhoneInfo pi){
        scanner.nextLine();
        System.out.print("이름 : ");
        pi.setName(scanner.nextLine());
        System.out.print("전화번호 : ");
        pi.setPhoneNumber(scanner.nextLine());
        System.out.print("생년월일 : ");
        pi.setBirthday(scanner.nextLine());
    }

    public static void main(String[] args) {
        // (1) setter / getter 사용
        PhoneInfo pi = new PhoneInfo();
        pi.setName("임미경");
        pi.setPhoneNumber("010-2345-6573");
        pi.setBirthday("1965.03.28.");
        pi.showPhoneInfo();

        PhoneInfo pi2 = new PhoneInfo();
        pi2.setName("김현수");
        pi2.setPhoneNumber("011-6435-1249");
        pi2.showPhoneInfo();

        // (2) 생성자 사용
        PhoneInfo pi3 = new PhoneInfo("임미경", "010-2345-6573", "1965.03.28.");
        PhoneInfo pi4 = new PhoneInfo("김현수", "011-6435-1249");
        pi3.showPhoneInfo();
        pi4.showPhoneInfo(); // birthday 안 적은 사람 birthday 조차 안 뜨게 하려면?

        // (3) 데이터 입력받기
        int i = 0;
        int choice = 1; // 데이터 입력과 종료 변수
        do{
            System.out.printf("선택하세요\n1. 데이터 입력\n2. 프로그램 종료\n선택 : ");
            choice = scanner.nextInt();
            if(choice==2){ break; }
            else if(choice==1){
                PhoneInfo pi5 = new PhoneInfo();
                inputPhoneinfo(pi5);
                pi5.showPhoneInfo();
            }
        } while(!(choice==2));
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
