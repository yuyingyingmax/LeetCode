package simple;

import java.util.Arrays;
/*
第88题 简单
 */
public class Merge {
    /*
    方法1：用辅助空间，遍历两个数组，依次填满第3个数组，但这不满足题目要求在nums1上进行合并
     */
    public void merge_one(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m+n];
        int k =0;
        int i = 0,j=0;
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                nums3[k]=nums1[i];
                i++;
            }else{
                nums3[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            nums3[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            nums3[k]=nums2[j];
            j++;
            k++;
        }
        nums1=nums3;
        for(int num:nums1){
            System.out.print(num);
        }
    }
    /*
    方法2：将nums2直接填到nums1的空位中，然后将nums1排序
     */
    public void merge_two(int[] nums1,int m, int[] nums2,int n){
        for(int i = 0;i<n;i++){
            nums1[m] = nums2[i];
            m++;
        }
        Arrays.sort(nums1);
        for(int num:nums1){
            System.out.print(num);
        }
    }
    /*
    方法3：从两个数组的末端开始比较，将大的放进nums1的后面，当遍历完其中一个数组后，将另一个填进nums1的空余位置。
     */
    public void merge(int[] nums1,int m, int[] nums2,int n){
        int i;
        int j;
        int k;
        for(i=m-1,j=n-1,k=i+j+1;i>=0&&j>=0;k--){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
        }
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }


    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};

        Merge m = new Merge();
//        m.merge_one(nums1,3,nums2,3);
//        m.merge_two(nums1,3,nums2,3);
        System.out.println(5/2);
    }
}
