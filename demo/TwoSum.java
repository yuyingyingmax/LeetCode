package eazy;
/*
第1题
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    我的解法，计算与nums中每个数字的差，并从该数字后寻找值等于这个差的数字的下标
     */
    public int[] twoSum(int[] nums,int target){
        int[] two = new int[2];
        System.out.println("未开始的两个数："+Arrays.toString(two));
        if(nums.length<2){
            return two;
        }
        for(int i = 0;i<nums.length;i++){
            int diff = target-nums[i];
            for(int j = i+1;j<nums.length;j++){
                if(nums[j] == diff){
                    two[0] =i;
                    two[1] =j;
                }
            }
        }
        System.out.println("计算后的两个数："+Arrays.toString(two));
        return two;
    }
    /*
    别人的解法：对nums中每个数字计算差值，若差值不在map中，则把当前数字和下标放入map。只需要遍历一遍
    但是使用了额外的空间，相对于我的解法算是以空间换了时间
     */
    public int[] twoSum_two(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
//        TwoSum ts = new TwoSum();
//        int[] nums = {2,7,11,15};
//        ts.twoSum(nums,9);
//        ts.twoSum_two(nums,9);
        int [][] p ={{1,2,3},{4,3,2},{2,2,6}};
        System.out.println(Arrays.toString(p));
    }

}
