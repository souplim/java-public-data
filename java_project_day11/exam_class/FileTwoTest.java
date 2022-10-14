package exam_class;

import java.io.*;

// [요구사항] 주어진 2개의 텍스트 파일(test.txt, result.txt)을 합하여 -> result.txt 파일은 직접 생성하셔도 되고 코드로 생성하셔도 됩니다
// 하나의 파일(writer.txt)로 만드는 프로그램을 작성하시오.
public class FileTwoTest {
    public static void main(String[] args) {

        char[] ch = "가장 위대한 영광은 한 번도 실패하지 않음이 아니라 실패할 때마다 다시 일어서는 데 있다.\n".toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append("행복은 성취의 기쁨과 창조적 노력이 주는 쾌감 속에 있다 (프랭클린 D. 루스벨트)\n");
        sb.append("우리가 할 수 있기 전에 배워야 하는 일들을, 우리는 하면서 배운다. (아리스토텔레스)\n");
        sb.append("저는 미래가 어떻게 전개될지는 모르지만, 누가 그 미래를 결정하는지는 압니다. (오프라 윈프리)");

        outStream("test.txt", ch);
        outStream("result.txt", sb);

        try (Reader reader = new FileReader("test.txt");
             Reader reader2 = new FileReader("result.txt");
             Writer writer = new FileWriter("writer.txt")){

            int read = 0;
            int read2 = 0;
            while(((read = reader.read()) != -1) || (read2 = reader2.read()) != -1){
                  writer.write(read);
                  writer.write(read2);
            }
        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public static void outStream(String file, Object obj){
        try {
            Writer writer = new FileWriter(file);

            if(obj instanceof char[]){
                char[] ch = (char[])obj;
                writer.write(ch);
            } else if(obj instanceof StringBuffer){
                String str = obj.toString();
                writer.write(str);
            }

            writer.close();
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
