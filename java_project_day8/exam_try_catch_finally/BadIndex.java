package exam_try_catch_finally;

public class BadIndex {
    public static void main(String[] args) {
        int[] array = new int[10];

        for(int i=0; i<10; i++)
            array[i] = i+1;

        int result = array[10];
        System.out.println(result);
        System.out.println("과연 이 문장이 실행될까요?");
    }
}
