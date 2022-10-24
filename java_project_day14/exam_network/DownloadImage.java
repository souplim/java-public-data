package exam_network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;
        int readByteNo;
        String website = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fen%2Fthumb%2F3%2F30%2FJava_programming_language_logo.svg%2F1200px-Java_programming_language_logo.svg.png&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FJava_(programming_language)&tbnid=6YsbFDSVEi3VJM&vet=12ahUKEwjgqNCQp_j6AhUNDt4KHfFKCAkQMygCegUIARDlAQ..i&docid=ty8cA0ylPEPayM&w=1200&h=2195&q=java&ved=2ahUKEwjgqNCQp_j6AhUNDt4KHfFKCAkQMygCegUIARDlAQ";

        try {
            URL url = new URL(website);
            URLConnection con = url.openConnection();
            in = new BufferedInputStream(con.getInputStream());

            out = new BufferedOutputStream(new FileOutputStream("Java_programming_language_logo.svg.png"));

            byte[] data = new byte[2048];
            while((readByteNo = in.read(data)) == -1)
                out.write(data, 0, readByteNo);
            System.out.println(website +"에서 이미지를 다운로드 했습니다.");

        } catch (MalformedURLException e){
            System.out.println("URL ERROR");
        } catch (IOException i){
            System.out.println("IO ERROR");
        } finally {
            try {
                if(out != null)
                    out.close();
                if(in != null)
                    in.close();
            } catch (Exception e){
                System.out.println("CLOSE ERROR");
            }
        }
    }
}
