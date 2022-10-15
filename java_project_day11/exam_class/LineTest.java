package exam_class;

import java.io.*;

public class LineTest {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("writer.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("line.txt"))){

        String readTxt = "";
        int i = 1;

        while((readTxt = br.readLine()) != null){
            bw.write(i+": ");
            bw.write(readTxt+"\n");
            i++;
        }

        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
