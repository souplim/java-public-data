package exam_try_catch_finally;

public class BadIndex2 {
    public static void main(String[] args) {
        int[] array = new int[10];

        try{
            for(int i=0; i<array.length; i++)
                array[i] = i+1;

            int result = array[12];
            System.out.println(result);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("배열의 인덱스가 잘못되었습니다.");
        }
        System.out.println("과연 이 문장이 실행될까요?");
    }
}
