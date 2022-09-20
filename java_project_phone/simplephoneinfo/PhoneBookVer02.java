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
class PhoneInfo2 {
    private String name;
    private String phoneNumber;
    private String birthday;

    PhoneInfo2(){ }
    PhoneInfo2(String name, String phoneNumber){
        this(name, phoneNumber, "");
    }
    PhoneInfo2(String name, String phoneNumber, String birthday){
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
        System.out.println("name : "+name);
        System.out.println("phone : "+phoneNumber);

        if(birthday != ""){ // "", null값일 때는 비교연산자 가능!
            System.out.println("birthday : "+birthday);
        }
    }
}

public class PhoneBookVer02 {
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

        // (2) 생성자 사용
        PhoneInfo pi2 = new PhoneInfo("김현수", "011-6435-1249");

        pi.showPhoneInfo();
        pi2.showPhoneInfo();

        // (3) 데이터 입력받아 출력
        int i = 0;
        int choice = 1; // 데이터 입력과 종료 변수
        do{
            System.out.printf("선택하세요\n1. 데이터 입력\n2. 프로그램 종료\n선택 : ");
            choice = scanner.nextInt();
            if(choice==2){ break; }
            else if(choice==1){
                PhoneInfo pi5 = new PhoneInfo();
                inputPhoneinfo(pi5); // static 메서드의 사용
                pi5.showPhoneInfo(); // 인스턴스 메서드의 사용
            }
        } while(!(choice==2));
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
