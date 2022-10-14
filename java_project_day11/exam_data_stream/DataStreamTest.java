package exam_data_stream;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) {
        double[] prices = {19.99, 9.97, 23.89, 4.23};
        int[] units = {12, 8, 23, 56};
        String[] descs = {"Apple","Orange","banana","grape"};

        // base.dat 파일에 각각 배열의 내용을 순서대로 저장하고 순서대로 읽어와서
        // 전체 합(가격*수량)을 출력하도록 프로그램을 작성해주세요.

        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("base.dat")));

            for(int i=0; i<prices.length; i++){
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } catch (IOException io){
            io.printStackTrace();
        } finally {
            try {
                if(out != null)
                    out.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        double price;
        int unit;
        String desc;
        double total = 0.0;

        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("base.dat")));
            System.out.println("------------ Your Order's ------------");
            while(in.available() > 0){ // available(): 현재 읽을 수 있는 바이트 수를 얻는다.
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.printf("price: %2f, unit: %d, description: %s\n", price, unit, desc);
                total += (unit * price);
            }
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                if(in != null)
                    in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("total: "+total);

    }
}
