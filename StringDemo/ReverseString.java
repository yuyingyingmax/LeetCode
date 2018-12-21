package eazy;
/*
第344题 简单
 */
import java.util.Stack;

public class ReverseString {
    /*
    字符串数组进行反转
     */
    public String reverseString_1(String s){
        char[] a = s.toCharArray();
        String ns = "";
        for(int i = a.length-1;i>=0;i--){
            ns += a[i];
        }
        return ns;
    }

    /*
    利用StringBuffer的reverse()方法进行逆置
    String是不可变的，而StringBuffer和StringBuilder是可变的
    StringBuffer和 StringBuilder差不多，但是StringBuffer是线程安全的，可以查看StringBuffer的类继承了StringBuilder且实现了Serializable接口
    StringBuilder快 StringBuffer安全

    挺快
     */
    public String reverseString_2(String s){
//        return new StringBuilder(s).reverse().toString();
        return new StringBuffer(s).reverse().toString();
    }

    /*
    利用栈结构进行逆置 (用时太长)
     */
    public String reverseString_3(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Character> c = new Stack<>();
        for(int i = 0;i<s.length();i++){
            c.push(s.charAt(i));//charAt(i)返回i位置上的字符
        }
        for(int i = 0;i<s.length();i++){
            sb.append(c.pop());
        }
        return sb.toString();
    }

    /*
    还是用字符数组，就地交换 也快
     */
    public String reverseString_4(String s){
        char[] c = s.toCharArray();
        for (int i = 0,j=c.length-1;i<j;i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(rs.reverseString_1(s));
        System.out.println(rs.reverseString_2(s));
        System.out.println(rs.reverseString_3(s));
        System.out.println(rs.reverseString_4(s));

    }
}
