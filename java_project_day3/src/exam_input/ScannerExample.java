package exam_input;

import java.util.Scanner;

// 이름, 도시, 나이, 체중, 독신여부(true/false)를 입력 받아 원하는 형태로 출력
public class ScannerExample {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력해주세요. > ");
        String name = scanner.nextLine();

        System.out.print("살고 있는 도시이름을 입력해주세요. > ");
        String city = scanner.nextLine();

        System.out.print("나이를 입력해주세요. > ");
        int age = scanner.nextInt();

        System.out.print("키를 입력해주세요. > ");
        double height = scanner.nextInt();
        scanner.nextLine(); // 나이 넣고 엔터 들어왔을 때 읽기만 하는 애를 하나 더 추가. 엔터 제거할 수 있는 명령어

        System.out.print("독신여부를 입력해주세요(y/n). > ");
        String mar = scanner.next(); // next()는 공백 이전 하나의 문자열을 읽는 것이므로 char이 아닌 String
        boolean married = (mar=="y") ? true : false;
        String married2 = married ? "독신" : "비독신";

        System.out.println(city+"에 살고 있는 "+age+"살 "+name+"님 안녕하세요.");
        System.out.println("키가 "+height+"cm이시고 "+married2+"입니다.");

    }
}
