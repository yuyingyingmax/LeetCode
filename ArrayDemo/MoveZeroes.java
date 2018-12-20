package eazy;
/*
第283题
 */
import java.util.Arrays;

public class MoveZeroes {
    /*
    我的方法：统计0的个数，然后每一趟将0与后一个非0元素交换，17ms，不太好
     */
    public void moveZeroes(int[] nums){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                count++;
            }
        }
        while(count>0){
            for(int i = 0;i<nums.length-1;i++){
                if(nums[i]==0 && nums[i+1]!=0){
                    int temp = nums[i];
                    nums[i] =nums[i+1];
                    nums[i+1] = temp;
                }
            }
            count--;
        }
        System.out.println(Arrays.toString(nums));
    }

    /*
    别人的方法：只要一次遍历即可
    count记录0的个数
    如果当前数字为0，则count++，i++
    直到当前数字不为0，当前数字之前有count个0，所以将当前数字放在位置[i-count]上即可。
     */
    public void moveZeroes_two(int[] nums){
        int count = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 0){
                count ++;
            }else{
                int temp = nums[i];
                nums[i] = 0;
                nums[i-count] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes mz = new MoveZeroes();
        mz.moveZeroes_two(nums);
    }
}
