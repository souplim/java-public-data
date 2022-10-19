package exam_class;

import java.io.*;

public class LineTest {
    public static void main(String[] args) {
        try( BufferedReader br = new BufferedReader(new FileReader("writer.txt"));
             PrintWriter pw = new PrintWriter(new FileWriter("line.txt"))){

            String readTxt = "";
            int i = 1;

            while((readTxt = br.readLine()) != null){
                pw.format("%6d: %s\n", i, readTxt);
                i++;
            }

            pw.flush();
            br.close();
            pw.close();
        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
