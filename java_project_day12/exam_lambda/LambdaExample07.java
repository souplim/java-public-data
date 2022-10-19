package exam_lambda;

import java.util.Arrays;

class EmptyStringException extends Exception {
    private static final long serialVersionUID = 1L;
    public EmptyStringException(){
        super("빈 문자열");
    }
}

interface StringFunction2 {
    String[] modify(String str) throws EmptyStringException;
}

public class LambdaExample07 {
    public static void main(String[] args) {
        String cityName= "KOREA,AUSTRALIA,CHINA,GERMANY,SPAIN,TURKEY";

        try {
            StringFunction2 sf = (str) -> {
                if(str.length()==0)
                    throw new EmptyStringException();
                return str.split(",");
            };

            String[] result = sf.modify(cityName);
            System.out.println("결과값: "+ Arrays.toString(result));
        } catch (EmptyStringException e){
            System.out.println(e.getMessage());
        }
    }
}
