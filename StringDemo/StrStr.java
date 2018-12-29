package eazy;
/*
第28题 简单
 */
public class StrStr {
    /*
    我的方法：
    1)先判断needel是否为空字符串；
    2)然后再比较这两个串是否完全相等
    3）从haystack的开头开始取出和needle大小相当的字串进行比较，找到第一个相等的则返回当前index
    4)上述条件都不符合则表示needel不是haystack的字串，返回-1
     */
    public int strStr(String haystack,String needle){
        if(needle.length()==0){
            return 0;
        }
        if(haystack.equals(needle)){
            return 0;
        }
        for (int i = 0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public int mystrStr(String haystack,String needle){
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int sourceCount = source.length;
        int targetCount = target.length;

        if(targetCount == 0){
            return 0;
        }
        char first = target[0];
        int max = sourceCount-targetCount;
        for(int i = 0;i<=max;i++){
            if(source[i] != first){
                while(++i<=max && source[i] != first);
            }
            if(i<=max){
                int j = i+1;
                int end = j + (targetCount-1);
                for(int k = 1;j<end && source[j]==target[k];j++,k++);
                if(j == end){
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "";
        StrStr ss = new StrStr();
        System.out.println(ss.mystrStr(haystack,needle));

//        System.out.println(ss.strStr(haystack,needle));
    }
}
