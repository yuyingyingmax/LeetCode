package demo;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    /*
    Excellent！
    异或法，这个数组中所有数字都成对出现，只有一个是单独的，所以他们异或运算的结果就是这个single number。任何数和0异或都是这个数本身
    这里的 ^ 操作符是按位异或 把数字转换成2进制进行异或 然后再转换成10进制
     */
    public int singleNumber2(int[] nums){
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] nums ={5,2,2,1,1};
        //System.out.println(sn.singleNumber(nums));
        System.out.println(sn.singleNumber2(nums));

       // System.out.println(4^0);
    }
}
