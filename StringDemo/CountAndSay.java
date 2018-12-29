package eazy;

import java.util.HashMap;
import java.util.Map;
/*
第38题 简单
 */
public class CountAndSay {
    /*
    我的方法：count方法用来计算报数
    map的key:数字 value:几个
    首先取出第一个数字并放入map中，从第二个开始遍历
    如果相等，map中对应key的value+1
    不相等的时候就输出当前的key和value
    然后把不相等的数字作为重新计数的第一个数字，加入map并设置值为1，这样做就不用担心相同的key的计数会出错。
     */
    public String count(String str){
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        char first = chars[0];
        String say = "";
        map.put(first,1);
        for(int i = 0;i<chars.length;){
            while(++i<chars.length&&chars[i] == first){
                map.put(first,map.get(first)+1);
            }
            say = say+map.get(first)+first;
            if(i<chars.length&&chars[i]!=first){
                first = chars[i];
                map.put(first,1);
            }
        }
        return say;
    }
    public String countAndSay(int n){
        if(n==1){
            return "1";
        }
        String str = "1";
        while(n>=2){
            str = count(str);
            n--;
        }
        return str;
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();;
        System.out.println(cas.countAndSay(2));
    }
}
