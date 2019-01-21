package simple;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        return ArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode ArrayToBST(int[] nums,int start,int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = ArrayToBST(nums,start,mid-1);
        node.right = ArrayToBST(nums,mid+1,end);
        return node;
    }

    public static void main(String[] args) {
        SortedArrayToBST sat = new SortedArrayToBST();
        int[] nums = {-10,-3,0,5,9};
        sat.sortedArrayToBST(nums);
    }
}
