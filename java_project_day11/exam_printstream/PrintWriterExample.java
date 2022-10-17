package exam_printstream;

import java.io.*;

public class PrintWriterExample {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;

        out = new PrintWriter(new FileWriter("output.txt"));
        out.println("변화를 원한다면,");
        out.println("제일 먼저 자신이 변화할 수 있다는 것과");
        out.println("변화하기까지 포기하지 않고");
        out.println("계속해서 노력할 수 있다는것을 믿어야 한다.");
        out.flush();

        in = new BufferedReader(new FileReader("output.txt"));
        String line;
        while((line = in.readLine()) != null)
            System.out.println(line);

        if(in != null)  in.close();
        if(out != null) out.close();
    }
}
