package exam_methodRef;

interface MyFunction<T> {
   int func(T[] array, T value);
}

class MyUtil {
    static <T> int count(T[] array, T value){
        int cnt = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] == value)
                cnt++;
        }
        return cnt;
    }
}

public class MethodReference02 {
    static <T> int test(MyFunction<T> mf, T[] array, T value){
        return mf.func(array, value);
    }

    public static void main(String[] args) {
        String[] list1 = {"blue","red","yellow","blue","red","blue"};
        Integer[] list2 = {10,50,10,50,40,10,90,10,20};

        int cnt = 0;
        cnt = test(MyUtil :: <String> count, list1, "blue");
        System.out.println(cnt);

        cnt = test(MyUtil :: <Integer> count, list2, 10);
        System.out.println(cnt);
    }
}
