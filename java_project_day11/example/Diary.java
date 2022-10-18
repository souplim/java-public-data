package example;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// [요구사항] 메모장 프로그램을 기반으로 간단한 일기장 프로그램을 만들어보세요.
// 년,월,일 순으로 날짜를 입력받아 파일명으로 사용해 보세요. 제목과 날씨를 입력받아 일기 내용의 첫 줄에 날짜와 날씨, 제목을 추가해 보세요.
public class Diary {
    public static void main(String[] args) {
        // 사용자로부터 입력 처리를 담당할 Scanner 선언
        Scanner scanner  = new Scanner(System.in);

        // 일기 파일 저장할 경로 지정
        File file = new File("C:/Temp/Diary");
        if(!file.exists())
            file.mkdirs(); // 파일에 지정된 경로로 폴더 생성

        File[] diaries = file.listFiles();

        // 반복문1
        // 무한반복. 사용자가 3을 입력하면 반복문을 탈출하도록 구현
        while(true) {
            System.out.println("1. 일기 읽기");
            System.out.println("2. 새 일기");
            System.out.println("3. 일기 삭제");
            System.out.println("4. 종료");
            System.out.println("원하는 작업 번호를 입력해주세요.");

            // 사용자가 입력한 명령 번호를 저장할 변수
            int taskNum;

            // nextLine()으로 한 줄 읽어온 뒤 정수형으로 변환해 taskNum에 대입
            // 예외가 발생한 경우(사용자가 정수 아닌 값 입력) "잘못된 입력입니다" 출력 후 반복문 1의 처음으로 돌아갑니다.
            try {
                String input = scanner.nextLine();
                taskNum = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            // 메모 읽기를 선택한 경우
            if(taskNum == 1) {
                diaries = file.listFiles();

                if(diaries.length==0) {
                    System.out.println("생성된 일기가 존재하지 않습니다.");
                    continue;
                }
                System.out.println("=== 일기 목록 ===");
                for(File f : diaries)
                    System.out.println(f.getName());

                System.out.println("원하시는 일기 날짜를 입력하세요.");

                String fileName = scanner.nextLine();

                // 파일 내용을 읽어들이기 위해 FileInputStream을 선언
                FileInputStream inputStream = null;

                // 사용자가 입력한 파일명을 가지고 FileInputStream을 생성
                // 파일이 없을 경우 "파일이 존재하지 않습니다."라는 메시지를 출력한 후 반복문 1의 처음으로 돌아감
                try {
                    inputStream = new FileInputStream("C:/Temp/Diary/"+fileName+".txt");
                } catch (FileNotFoundException e){
                    System.out.println("해당 일기가 존재하지 않습니다.");
                    continue;
                }

                // FileInputStream이 성공적으로 생성되면 안내 메세지를 출력
                System.out.println(fileName + "의 내용을 출력합니다.");

                // FileInputStream으로부터 파일의 내용을 읽어들일 Scanner를 선언
                Scanner reader = new Scanner(inputStream);

                // 반복문2
                // 파일의 내용을 한 줄씩 읽어 끝까지 출력
                while(reader.hasNextLine())
                    System.out.println(reader.nextLine());
                System.out.println("\n");

                // 파일을 다 사용했으면 닫아줌
                reader.close();
            }

            // 새 메모를 선택한 경우
            else if(taskNum == 2){
                // 저장 날짜로 파일명 지정하기
                Date today = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                // 새 메모를 저장하기 위해 새 파일명(날짜)을 입력받기
                String fileName = sdf.format(today);

                // 파일을 쓰기 위해 FileWriter 선언
                FileWriter writer = null;

                // 사용자가 입력한 파일명을 가지고 FileWriter를 생성
                // 파일 생성에 실패한 경우 "파일 생성에 실패했습니다." 출력 후 반복문의 처음으로 돌아감
                try {
                    writer = new FileWriter("C:/Temp/Diary/"+fileName+".txt");
                } catch (IOException e){
                    System.out.println("파일 생성에 실패했습니다.");
                    continue;
                }

                // 사용자가 입력한 제목과 날씨를 파일의 첫 줄이 입력
                System.out.println("제목과 날씨를 입력하세요.");
                System.out.print("제목: ");
                String title = scanner.nextLine();
                System.out.print("날씨: ");
                String weather = scanner.nextLine();

                // 사용자가 입력한 문자열을 파일에 쓰고 줄바꿈 문자를 통해 줄바꿈 추가
                try {
                    writer.write("날짜: "+fileName+" 날씨: "+weather+" 제목: "+title+"\n");
                    diaries = file.listFiles();
                } catch (IOException e){
                    System.out.println("파일에 텍스트를 추가하지 못했습니다.");
                }

                System.out.println("메모할 문자열을 입력하세요.");
                System.out.println("(종료: 빈 줄에서 엔터키 입력)");

                // 반복문3
                // 계속해서 사용자 입력 값을 받기 위해 무한반복
                while(true) {
                    String input = scanner.nextLine();

                    // 사용자가 입력한 값이 빈 문자열("")이라면 파일에 쓸 문자열을 입력받는 반복문3 탈출
                    if(input.equals(""))
                        break;

                    // 사용자가 입력한 문자열을 파일에 쓰고 줄바꿈 문자를 통해 줄바꿈 추가
                    try {
                        writer.write(input);
                        writer.write("\n");
                    } catch (IOException e){
                        System.out.println("파일에 텍스트를 추가하지 못했습니다.");
                    }
                }

                // 빈 문자열을 입력받아 반복문3을 탈출했다면 입력이 종료된 것이므로 파일 닫아줌
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("파일을 닫는 데 실패했습니다.");
                }
            }

            // 삭제를 선택한 경우
            else if(taskNum == 3) {
                if(diaries == null) {
                    System.out.println("생성된 일기가 존재하지 않습니다.");
                    continue;
                }
                System.out.println("=== 일기 목록 ===");
                for(File f : diaries)
                    System.out.println(f.getName());

                System.out.println("삭제할 일기 날짜를 입력하세요.");

                String fileName = scanner.nextLine();

                // 파일 내용을 읽어들이기 위해 FileInputStream을 선언
                FileInputStream inputStream = null;

                // 사용자가 입력한 파일명을 가지고 FileInputStream을 생성
                // 파일이 없을 경우 "파일이 존재하지 않습니다."라는 메시지를 출력한 후 반복문 1의 처음으로 돌아감

                File fileDelete = new File("C:/Temp/Diary/"+fileName+".txt");
                if(fileDelete.exists())
                    if(fileDelete.delete()) {
                        System.out.println("해당 일기가 삭제되었습니다.");
                        diaries = file.listFiles();
                    }
            }

            // 종료를 선택한 경우
            else if(taskNum == 4) {
                // 프로그램을 종료한다는 메세지 출력 후 반복문 1을 탈출
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 사용자가 입력한 값이 1, 2, 3 중 하나가 아닌 경우 "잘못된 입력입니다"라는 메시지를 출력
            else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
