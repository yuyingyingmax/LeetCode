package eazy;
/*
第125题 简单
 */
public class ValidatePalindrome {
    /*
    我的方法：用正则表达式剔除字符串中的非字母和数字，，然后转换成小写，再进行比较
     */
    public boolean isPalindrome(String s){
        String s1 = s.toLowerCase().replaceAll("[^a-z^0-9]","");
        System.out.println(s1.length());
        if(s1.length()==0){
            return true;
        }
        char[] arr = s1.toCharArray();
        for(int i = 0, j=arr.length-1;i<j;i++,j--){
            if(arr[i]!=arr[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidatePalindrome vp = new ValidatePalindrome();
        System.out.println(vp.isPalindrome("0P"));
    }
}
