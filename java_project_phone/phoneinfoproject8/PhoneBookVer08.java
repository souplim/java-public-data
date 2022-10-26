package phoneinfoproject8;

import java.io.*;
import java.util.InputMismatchException;

interface Menu {
    // 1. 데이터 입력 2. 데이터 검색 3. 데이터 삭제 4. 프로그램 종료
    int INPUT = 1, SEARCH = 2, DELETE = 3, EXIT = 4;
}

public class PhoneBookVer08 {

    public static void main(String[] args) {
        PhoneBookManager pbm = PhoneBookManager.getInstance();
        int menu;

        while (true) {
            try {
                MenuViewer.intro();
                menu = MenuViewer.sc.nextInt();
                MenuViewer.sc.nextLine();

                if (menu < Menu.INPUT || Menu.EXIT < menu) {
                    throw new MenuChoiceException(menu);
                }

                switch (menu) {
                    case Menu.INPUT:
                        pbm.input();
                        break;
                    case Menu.SEARCH:
                        pbm.search();
                        break;
                    case Menu.DELETE:
                        pbm.delete();
                        break;
                    case Menu.EXIT:
                        // 입력된 데이터를 파일에 저장
                        pbm.savePhoneBook();
                        System.out.println("프로그램을 종료합니다.");
                        return;
                }
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
            } catch (InputMismatchException ise) {
                System.out.println("숫자 1~4 사이의 값을 입력해주세요"); // 이 문장 menu 선택에서 문자열로 들어가서 무한반복되는 오류
                MenuViewer.sc.nextLine();
            }
        }
    }
}

class PhoneInfo implements Serializable {
    // serialVersionUID는 같은 클래스임을 알려주는 식별자 역할. Serializable 인터페이스를 구현한 클래스 컴파일하면 자동적으로 추가됨
    private static final long serialVersionUID = 1L;
    private String name;
    private String phoneNumber;

    PhoneInfo(){ }
    PhoneInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber; }
    public String getPhoneNumber(){ return phoneNumber; }

    public void showPhoneInfo(){
        System.out.println("name : "+getName());
        System.out.println("phone : "+getPhoneNumber());
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof PhoneInfo){
            PhoneInfo p = (PhoneInfo)obj;
            if(this.name.equals(p.name))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return name.hashCode(); // String 클래스의 hashCode()
    }
}

class PhoneUnivInfo extends PhoneInfo implements Serializable { // 대학동기들
    private String major;
    private int year;

    public PhoneUnivInfo(){ }
    public PhoneUnivInfo(String name, String phoneNumber, String major, int year){
        super(name, phoneNumber);
        this.major = major;
        this.year = year;
    }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("major : "+getMajor());
        System.out.println("year : "+getYear());
    }
}

class PhoneCompanyInfo extends PhoneInfo implements Serializable { // 회사동료
    private String company;

    public PhoneCompanyInfo(){ }
    public PhoneCompanyInfo(String name, String phoneNumber, String company){
        super(name, phoneNumber);
        this.company = company;
    }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    @Override
    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("company : "+getCompany());
    }
}

class MenuChoiceException extends Exception {
    private int wrongChoice;

    public MenuChoiceException(int choice){
        super("잘못된 선택이 이뤄졌습니다.");
        wrongChoice = choice;
    }

    public void showWrongChoice(){
        System.out.println(wrongChoice+"에 해당하는 선택은 존재하지 않습니다.");
    }
}
