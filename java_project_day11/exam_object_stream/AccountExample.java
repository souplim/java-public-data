package exam_object_stream;

/*[조건]
 * 클래스 : Account
 * 필드 : accountNo, ownerName, balance
 *
 * 파일명은 account.dat이다.
 * 직렬화하여 저장되어야 하는 데이터는 123-4535-33478 홍길동 100000.
 * 역직렬화하여 화면에 보여지는 형태는
 * 계좌번호 : 123-4535-33478
 * 예금주명 : 홍길동
 * 금액 :100000
 * 으로 보여질 수 있도록 코딩해 주세요.*/

import java.io.*;

class Account implements Serializable {
    private String accountNo;
    private String ownerName;
    private int balance;

    Account(String accountNo, String ownerName, int balance){
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    @Override
    public String toString(){
        return "계좌번호 : "+accountNo+"\n예금주명 : "+ownerName+"\n금액 : "+balance;
    }
}

public class AccountExample {
    public static void main(String[] args) {
        String file = "account.dat";
        output(file);
        input(file);
    }

    public static void output(String file){
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

            oos.writeObject(new Account("123-4535-33478","홍길동",100000));
            oos.flush(); // 만약을 대비한 버퍼 비우기
            
        } catch (IOException io){
            System.out.println(io);
        }
    }

    public static void input(String file){
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){

            Account ac = (Account)ois.readObject();
            System.out.println(ac);
            
        } catch(ClassNotFoundException cnf){
            System.out.println("클래스를 찾을 수 없습니다.");
        } catch(IOException io){
            // readObject()는 파일의 끝까지 읽기 때문에 출력 코드 넣으면 반드시 그 코드가 나오기 때문에 아무것도 넣지 않는다.
        }
    }
}
