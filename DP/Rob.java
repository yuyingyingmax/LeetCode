package simple;

public class Rob {
    public int rob(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] sums= new int[nums.length];
        sums[0] = nums[0];
        sums[1] = nums[0]>nums[1]?nums[0]:nums[1];
        for(int i = 2;i<nums.length;i++){
            sums[i] = (sums[i-1]>sums[i-2]+nums[i])?sums[i-1]:sums[i-2]+nums[i];
        }
        return sums[nums.length-1];

    }


    public static void main(String[] args) {
        Rob r = new Rob();
        int[] nums = {2,1,1,2};
        System.out.println(r.rob(nums));
    }
}
