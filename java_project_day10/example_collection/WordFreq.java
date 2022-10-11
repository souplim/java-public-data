package example_collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*[요구사항] 문자열에 포함된 단어의 빈도를 계산하여 단어를 Key로, 빈도를 Value로 저장하여 출력해 보세요.
 * String[] sample = { "to", "be", "or", "not", "to", "be", "is", "a", "problem"};
 * [실행결과]
   총 단어 수 : 7개
   {a=1, not=1, be=2, or=1, problem=1, is=1, to=2}
*/
public class WordFreq {
    public static void main(String[] args) {
        String[] sample = { "to", "be", "or", "not", "to", "be", "is", "a", "problem"};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<sample.length; i++){
            map.put(sample[i], 0);
        }

        for(int i=0; i<sample.length; i++){
            if(map.containsKey(sample[i])){
                map.replace(sample[i], map.get(sample[i])+1);
            }
        }

        System.out.println(map);
    }
}
