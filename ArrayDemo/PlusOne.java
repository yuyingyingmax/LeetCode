package demo;
/*
第66题
 */
import java.util.Arrays;

public class PlusOne {
    public int[] plus(int[] digits, int index){
        if(digits[index]<9){
            digits[index] += 1;
            return  digits;
        }
        if(digits[index]==9){
            digits[index] = 0;
            if(index-1>=0){
                plus(digits,index-1);
            }
        }
        return digits;
    }
    /*
    自己的解法，大概和plusOne2差不多 但用了递归
     */
    public int[] plusOne(int[] digits){
        int[] dig = plus(digits,digits.length-1);
        if(dig[0] == 0){
            dig = new int[dig.length+1];
            dig[0] = 1;
        }
        return dig;
    }

    /*
    第二种是第一种的改良版，没有递归直接在for中解决问题
     */
    public int[] plusOne2(int[] digits){
        int n = digits.length;
        for(int i = n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        digits = new int[n+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        PlusOne po = new PlusOne();
        System.out.println(Arrays.toString(po.plusOne2(digits)));

    }
}
