package exam_generic_type_book.generic_interface;

interface Maximum<T extends Comparable<T>> {
    T max();
}

class NumUtil<T extends Comparable<T>> implements Maximum<T> {
    T[] value;

    public NumUtil(T[] value){ this.value = value; }

    @Override
    public T max() { // 최대값 반환 제네릭 메서드
        T v = value[0];
        for(int i=0; i<value.length; i++)
            if(value[i].compareTo(v) > 0)
                v = value[i];
        return v;
    }
}

public class GenericInterfaceTest {
    public static void main(String[] args) {
        Integer[] inum = {50, 10, 20, 30, 40};
        Double[] dnum = {1.0, 2.0, 5.0, 3.0, 4.0};
        String[] snum = {"1","2","3","4","5"};

        NumUtil<Integer> iutil = new NumUtil<>(inum);
        NumUtil<Double> dutil = new NumUtil<>(dnum);
        NumUtil<String> sutil = new NumUtil<>(snum);
        System.out.println("inum 최대값 : "+ iutil.max());
        System.out.println("dnum 최대값 : "+ dutil.max());
        System.out.println("snum 최대값 : "+ sutil.max());
    }
}
