package phoneinfoproject5;

class PhoneInfo {
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
        System.out.println("name : "+name);
        System.out.println("phone : "+phoneNumber);
    }
}

class PhoneUnivInfo extends PhoneInfo{ // 대학동기들
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

    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("major : "+getMajor());
        System.out.println("year : "+getYear());
    }
}

class PhoneCompanyInfo extends PhoneInfo{ // 회사동료
    private String company;

    public PhoneCompanyInfo(){ }
    public PhoneCompanyInfo(String name, String phoneNumber, String company){
        super(name, phoneNumber);
        this.company = company;
    }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("company : "+getCompany());
    }
}

enum Menu {
    INPUT(1), SEARCH(2), DELETE(3), EXIT(4);
    private int i;
    Menu(int i){ this.i = i; }
    public int getValue(){ return i; }
}

public class PhoneBookVer05 {
    public static void main(String[] args) {
        PhoneBookManager pbm = PhoneBookManager.getInstance();
        int choice;

        while(true) {
            MenuViewer.intro();
            choice = MenuViewer.sc.nextInt();
            Menu menu = Menu.valueOf(choice);
//            week w = week.valueOf(ans.toUpperCase());
            MenuViewer.sc.nextLine();

            switch(menu) {
                case INPUT :
                    pbm.input();
                    break;
                case SEARCH :
                    pbm.search();
                    break;
                case DELETE :
                    pbm.delete();
                    break;
                case EXIT :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default :
                    System.out.println("잘못 입력 하셨습니다.");
                    return;
            }
        }
    }
}
