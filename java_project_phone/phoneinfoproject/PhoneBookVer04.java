package phoneinfoproject;

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
        System.out.println("name : "+super.getName());
        System.out.println("phone : "+super.getPhoneNumber());
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
        System.out.println("name : "+super.getName());
        System.out.println("phone : "+super.getPhoneNumber());
        System.out.println("company : "+getCompany());
    }
}

public class PhoneBookVer04 {
    public static void main(String[] args) {
        PhoneBookManager pbm = new PhoneBookManager();
        int menu;

        while(true) {
            MenuViewer.intro();
            menu = MenuViewer.sc.nextInt();
            MenuViewer.sc.nextLine();

            switch(menu) {
                case 1 :
                    pbm.input();
                    break;
                case 2 :
                    pbm.search();
                    break;
                case 3 :
                    pbm.delete();
                    break;
                case 4 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default :
                    System.out.println("잘못 입력 하셨습니다.");
                    return;
            }
        }
    }
}
