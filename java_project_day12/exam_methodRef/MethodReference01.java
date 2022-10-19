package exam_methodRef;

interface StringFunction {
    String modify(String str);
}

public class MethodReference01 {
//    static String func(String str){
    String func(String str){ // static 제어자 삭제
        String result = "";
        char c;
        for(int i=0; i<str.length(); i++){
            c = str.charAt(i);
            if(c==',')
                result += " ";
            else
                result += c;
        }
        return result;
    }

    public static void main(String[] args) {
//        StringFunction sf = MethodReference01::func;
        MethodReference01 mf = new MethodReference01();
        StringFunction sf = mf::func;

        String cityName = "KOREA,AUSTRALIA,CHINA,GERMANY,SPAIN,TURKEY";
        String result = sf.modify(cityName);
        System.out.println("실행결과: "+result);

        String str2 = "서울,북경,도쿄,뉴욕,발리";
        result = sf.modify(str2);
        System.out.println("실행결과2: "+result);

    }
}
