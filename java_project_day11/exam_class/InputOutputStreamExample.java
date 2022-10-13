package exam_class;

/*
 * "C:/Temp/intest.txt"를 생성한다. (직접 파일 생성)
 * 해당 파일에는 아래의 내용을 작성한 후 저장한다.
 	Hello World!
 	My Name is IOStream.
 * 이 내용을 읽어 C:/Temp/outtest.txt파일을 생성하여 저장한다.
 */

import java.io.*;

public class InputOutputStreamExample {
    public static void main(String[] args) {
//        InputStream is = null;
//        OutputStream os = null;
//
//        try {
//            is = new FileInputStream("C:/Temp/intest.txt");
//            os = new FileOutputStream("C:/Temp/outtest.txt");
//
//            int readByte = -1;
//
//            while(((readByte = is.read()) != -1)){
//                os.write(readByte);
//            }
//            System.out.println("파일 복사가 완료되었습니다.");
//        } catch(FileNotFoundException fnf){
//            System.out.println("파일이 존재하지 않거나 경로가 맞지 않아 더 이상 작업을 진행할 수 없습니다.");
//        } catch(IOException io){
//            System.out.println("파일 입출력에 문제가 발생하여 더 이상 작업을 진행할 수 없습니다.");
//        } catch(Exception e){
//            System.out.println("오류 발생으로 더 이상 작업을 진행할 수 없습니다.");
//        } finally {
//            try {
//                if(is != null)
//                    is.close(); // 인스턴스가 만들어졌을 때만 해제하겠다
//                if(os != null)
//                    os.close();
//            } catch (Exception ee){
//                ee.printStackTrace();
//            }
//        }

        // try-with-resources 문 이용
        try(FileInputStream is = new FileInputStream("C:/Temp/intest.txt");
            FileOutputStream os = new FileOutputStream("C:/Temp/outtest.txt")){

            int readByte = -1;

            while((readByte = is.read()) != -1)
                os.write(readByte);

            System.out.println("파일 복사가 완료되었습니다.");
        } catch (FileNotFoundException fnf){
            System.out.println("파일이 존재하지 않거나 경로가 맞지 않아 더 이상 작업을 진행할 수 없습니다.");
        } catch (IOException io){
            System.out.println("파일 입출력에 문제가 발생하여 더 이상 작업을 진행할 수 없습니다.");
        } catch (Exception e){
            System.out.println("오류 발생으로 더 이상 작업을 진행할 수 없습니다.");
        }
    }
}
