package exam_class;

import java.io.*;
import java.util.*;

public class PhoneExplorer {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        String file = "phone.txt";

        writePhoneFile(file);
        readPhoneFile(file);
        processQuery();
    }

    public static void writePhoneFile(String file){

        System.out.println("=== 전화번호 입력 ===");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            while(true){
                System.out.print("이름: ");
                String name = scanner.nextLine().trim();
                if("그만".equals(name) || "".equals(name)) break;
                System.out.print("전화번호: ");
                String phoneNum = scanner.nextLine().trim();
                if("그만".equals(phoneNum)) break;

                bw.write(name+"\n");
                bw.write(phoneNum+"\n");
            }
        } catch (IOException io){ io.printStackTrace(); }

    }

    public static void readPhoneFile(String file){
        try (BufferedReader bw = new BufferedReader(new FileReader(file))){

            String key = "";
            String value = "";
            while((key = bw.readLine()) != null) {
                value = bw.readLine();
                map.put(key, value);
            }
        } catch (IOException io){ io.printStackTrace(); }
    }

    public static void processQuery(){

        System.out.println("=== 전화번호 검색 ===");

        loop :
        while(true){
            System.out.print("이름: ");
            String name = scanner.nextLine();
            if("종료".equals(name)) break;

            // 1
            Iterator<String> it = map.keySet().iterator();
            while(it.hasNext()){
                String key = it.next();
                if(key.equals(name)){
                    String value = map.get(key);
                    System.out.println("이름: "+key+", 전화번호: "+value);
                    continue loop;
                }
            }
            System.out.println("검색하신 데이터가 존재하지 않습니다.");

            // 2
//            for(Map.Entry<String, String> sd : map.entrySet()){
//                String key = sd.getKey();
//                String value = sd.getValue();
//                System.out.println("이름: "+key+", 전화번호: "+value);
//            }
        }
    }
}
