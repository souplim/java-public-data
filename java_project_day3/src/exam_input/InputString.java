package exam_input;

import java.util.Scanner;

/* 각자의 이름, 나이, 주소를 입력받아 아래와 같이 출력할 수 있도록 작성해 주세요.
 * 홍길동님 안녕하세요. 50살이시네요.
 * 주소는 서울특별시 강남구 테헤란로14길 6 남도빌딩 4F
 */
public class InputString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int age;
        String name, address;


        System.out.print("이름을 입력해주세요. > ");
        name = scanner.nextLine();

        System.out.print("나이를 입력해주세요. > ");
        age = scanner.nextInt();
        scanner.nextLine(); // 나이 넣고 엔터 들어왔을 때 읽기만 하는 애를 하나 더 추가. 엔터 제거할 수 있는 명령어

        System.out.print("주소를 입력해주세요. > "); // 위에 숫자를 받을 때 치는 엔터값을 문자로 인식해서 그냥 넘어가버림
                                                  // (문자-문자-문자/숫자-숫자-숫자 는 상관 없음. 숫자-문자일 때)
        address = scanner.nextLine();

        System.out.println();
        System.out.println(name+"님 안녕하세요. "+age+"살이시네요.");
        System.out.println( "주소는 "+address+"입니다.");

        scanner.close();
    }
}
