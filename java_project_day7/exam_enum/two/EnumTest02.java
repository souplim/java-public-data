package exam_enum.two;

enum Mandarin {
    금귤(6000), 한라봉(5000), 레드향(3000), 천혜향(4000), 황금향(8000);

    private int price;

    Mandarin(int price){
        this.price = price;
    }

    int getPrice(){
        return price;
    }
}

public class EnumTest02 {
    public static void main(String[] args){

        Mandarin ma = Mandarin.한라봉;
        if(ma == Mandarin.한라봉)
            System.out.println("ma는 한라봉입니다.");
        System.out.println(ma.toString() + " 가격 : "+ma.getPrice());

        Mandarin list[] = Mandarin.values();
        System.out.println("== 귤의 종류 ==");
        for(Mandarin m : list)
            System.out.println(m.toString()+":"+m.getPrice());

    }
}
