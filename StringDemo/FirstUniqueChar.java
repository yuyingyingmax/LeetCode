package eazy;
/*
第387题 简单
 */
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    /*
    我的方法，把字符串放在map中，然后逐个比较，第一个value=1的返回index
     */
    public int firstUniqueChar(String s){
        char[] c = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<c.length;i++){
            if(map.containsKey(c[i])){
                map.put(c[i],map.get(c[i])+1);
            }else{
                map.put(c[i],1);
            }
        }
        int index = -1;
        for(int i =0;i<c.length;i++){
            if(map.get(c[i])==1){
                return i;
            }
        }
        return index;
    }
    /*
    别人的答案
     */
    public int firstUniqueChar_2(String s){
        int res = -1;
        for(char ch='a';ch<='z';ch++){
            int index = s.indexOf(ch);//s中第一次出现ch的位置，若没有则为-1
            if(index != -1 && index == s.lastIndexOf(ch)){//出现次数唯一
                res = (res == -1 ||res>index)?index:res;//初始res=-1，将index赋值给res作为第一个不重复的字符，后面进行比较，只取index小的
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FirstUniqueChar fuc=new FirstUniqueChar();
        System.out.println(fuc.firstUniqueChar("oovvee"));
    }
}
