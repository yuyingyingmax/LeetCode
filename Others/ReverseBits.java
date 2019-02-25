package simple;
/*
190题
 */
public class ReverseBits {
    /*
    思路：将n的末位给result的末位，且result左移31次
    n&1得到n的末位；n右移；result左移后和temp做或操作将n的末位给到result。
     */
    public int reverseBits(int n){
        int result = 0;
        int i = 0;
        while (i < 32) {
            int temp = n & 1;
            n = n >> 1;
            result = (result << 1) | temp;
            i++;
        }
        return result;
    }
}
