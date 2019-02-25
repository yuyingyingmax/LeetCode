package simple;
/*
第191题
 */
public class HammingWeight {
    /*
    思路：用n和n-1做与运算，得到的结果比原数最右边少一个1，因此直到数字=0时，做了几次运算，就有几个1
    这个方法在很多二进制的问题中都可以尝试使用
     */
    public int hammingWeight(int n){
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight =new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(-3));
    }
}
