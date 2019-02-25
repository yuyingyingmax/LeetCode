package simple;
/*
第461题
 */
public class HammingDistance {
    /*
    思路：要算两个数字二进制位不同的数目，可以先对两个数字做异或（^)运算，得到的结果中1的个数就是对应位置不同的个数
          然后再参照之前计算1的个数的方法，用n和（n-1)做与运算，有几个1就做几次，直到为0

     */
    public int hammingDistance(int x, int y){
        int count = 0;
        int n = x^y;
        while(n!=0){
            count++;
            n = n & (n-1);
        }
        return count;
    }



    public static void main(String[] args) {

    }
}
