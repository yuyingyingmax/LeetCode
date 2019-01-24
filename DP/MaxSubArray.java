package simple;
/*
第53题 简单
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int nowSum = 0;
        for(int i = 0;i<nums.length;i++){
            nowSum += nums[i];
            if(nowSum>maxSum){
                maxSum=nowSum;
            }
            if(nowSum<0){
                nowSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArray msa = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(msa.maxSubArray(nums));
    }
}
