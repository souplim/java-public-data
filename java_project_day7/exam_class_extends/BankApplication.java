package exam_class_extends;

import java.util.Scanner;

class Account {
    private String ano;
    private String owner;
    private int balance;

    public Account(){ }
    public Account(String ano, String owner, int balance){
        this.ano = ano;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAno(){ return ano; }
    public void setAno(String ano){ this.ano = ano; }
    public String getOwner(){ return owner; }
    public void setOwner(String owner){ this.owner = owner; }
    public int getBalance(){ return balance; }
    public void setBalance(int balance){ this.balance = balance; }
}
public class BankApplication {
    public static int i = 0;
    public static Scanner scanner = new Scanner(System.in);


    public static void createAccount(Account[] ac){
        System.out.println("계좌생성");
        System.out.println("------------");
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
//        ac[i].setAno(scanner.nextLine());
        System.out.print("계좌주: ");
        String owner = scanner.nextLine();
        System.out.print("초기입금액: ");
        int balance = scanner.nextInt();

        System.out.print("결과: 계좌가 생성되었습니다.");
        ac[i] = new Account(ano, owner, balance);
        i++;
    }

    public static void accountList(Account[] ac){
        System.out.println("계좌목록");
        System.out.println("------------");
        for(i=0; i<ac.length; i++){
            System.out.printf("%16s %7s %-8d",ac[i].getAno(),ac[i].getOwner(),ac[i].getBalance());
        }
    }
    public static void deposit(Account[] ac){
        System.out.println("예금");
        System.out.println("------------");
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
        name:
        do{
            for(i=0; i<ac.length; i++){
                if((ac[i].getAno()).equals(ano)){
                    int deposit = scanner.nextInt();
                    ac[i].setBalance(ac[i].getBalance()+deposit);
                    break name;
                }
                if(!(ac[i].getAno()).equals(ano)){
                    System.out.println("원하시는 계좌를 찾지 못했습니다.");
                    // 종료는 어떻게?
                }
            }
        }while(true);

    }
    public static void withdraw(Account[] ac){

    }

    public static void main(String[] args) {
            do{
            System.out.println("----------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("----------------------------");
            System.out.print("선택> ");

            int choice = scanner.nextInt();
            System.out.println("------------");


            switch(choice){
                case 1 :
                    Account[] ac = new Account[5]; // ?
                    BankApplication.createAccount(ac);
                    break;
                case 2 :

                    break;
                case 3 :

                    break;
                case 4 :

                    break;
                case 5 :

                    break;
                default :
                    System.out.println("잘못된 숫자를 입력하셨습니다.");
                    break;
            }
        }while(true);








    }
}
