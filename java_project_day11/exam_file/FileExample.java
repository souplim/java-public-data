package exam_file;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File dir = new File("C:/Temp3/Dir");
        File file1 = new File("C:/Temp/file1.txt");
        File file2 = new File("C:/Temp/file2.txt");

        if(!dir.exists())
            dir.mkdirs();

        if(file1.exists())
            file1.delete();

        if(!file2.exists())
            file2.createNewFile();

        // 파일에 데이터 출력 후 읽기
        if(file2.exists()){
            try(PrintWriter out = new PrintWriter(file2)) {
                out.println("hello java!");
            }
            System.out.println("파일 이름 : "+ file2.getName());
            System.out.println("파일 경로 : "+ file2.getPath());
            System.out.println("쓰기 가능 : "+ file2.canWrite());
            System.out.println("읽기 가능 : "+ file2.canRead());
            System.out.println("파일 길이 : "+ file2.length()+"바이트");
        } else
            System.out.println("작업할 파일이 존재하지 않음");

        File temp = new File("C:/Temp");
        System.out.println("경로: "+temp.getPath());
        System.out.println("부모: "+temp.getParent());
        System.out.println("절대경로: "+temp.getAbsolutePath());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

        File[] contents = temp.listFiles();
        System.out.println("날짜 \t\t시간 \t 형태 \t\t크기 \t이름");
        System.out.println("-------------------------------------------------------");
        for(File file : contents) {
            System.out.print(sdf.format(new Date(file.lastModified())));

            if(file.isDirectory())
                System.out.print("\t<DIR>\t\t\t" + file.getName());
            else
                System.out.print("\t\t\t" + file.length() +"\t"+file.getName());
            System.out.println();
        }

    }
}
