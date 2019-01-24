package simple;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
    private int[] nums;
    private int[] originNums;

    public ShuffleAnArray(int[] nums){
        this.nums=nums;
        this.originNums = Arrays.copyOf(nums,nums.length);
    }

    public int[] reset(){
        return this.originNums;
    }

    public int[] shuffle(){
        if(nums.length==0||nums.length==1){
            return nums;
        }

        Random random = new Random();
        int index = random.nextInt(nums.length);
        int temp = 0;
        temp = nums[0];
        nums[0] = nums[index];
        nums[index] =temp;
        return nums;
    }
}
