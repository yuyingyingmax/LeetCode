package eazy;
/*
第7题 简单

 */
public class ReverseInt {
    /*
    使用long计算，最后判断是否溢出
     */
    public int reverse(int x){
        long result = 0;
        while(x!=0){
            result = result*10 + x%10;
            x /= 10;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            result = 0;
        }
        return (int)result;
    }
    /*
    关于Integer.MAX_VALUE 和MIN_VALUE
    MAX_VALUE = 0x7fffffff;
    MIN_VALUE = 0x80000000；
    这是16进制，补码表示:0x7fffffff代表2^31 - 1 （反码+1=补码，所以-1 ;正数的反码就等于原码，所以代表2^31 - 1）
     0x80000000代表-2^31 这个最小值没有反码和原码
     */

    public static void main(String[] args) {
        ReverseInt ri = new ReverseInt();
        System.out.println(ri.reverse(100));
    }
}
