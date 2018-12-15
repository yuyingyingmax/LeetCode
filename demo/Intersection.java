package demo;
/*
第350题
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {
    public void sort(int[] nums){
        int[] temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
    }

    public void sort(int[] nums,int left, int right, int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(nums,left,mid,temp);
            sort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }

    public void merge(int[] nums,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0;

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[t++] = nums[i++];
            }else{
                temp[t++] = nums[j++];
            }
        }

        while(i<=mid){
            temp[t++] = nums[i++];
        }

        while(j<=right){
            temp[t++] = nums[j++];
        }

        t = 0;
        while(left<=right){
            nums[left++] = temp[t++];
        }
    }

    /*
    有序的情况下可以这么做
     */
    public int[] intersect(int[] nums1,int[] nums2){
        sort(nums1);
        sort(nums2);

        int i = 0;
        int j = 0;
        int n  = 0;
        int len = 0;
        if(nums1.length>nums2.length){
            len = nums2.length;
        }else{
            len = nums1.length;
        }
        int[] interl = new int[len];

        while(i< nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                interl[n++]= nums1[i++];
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int [] inter = new int[n];
        for(int ii =0;ii<inter.length;ii++){
            inter[ii] = interl[ii];
        }
        return inter;
    }

    /*
    第二种方法，利用map做nums1的数字和次数的key-value对，然后用nums2进行对比
     */
    public int[] intersect2(int[] nums1,int[] nums2){
        Map<Integer,Integer> counter = new HashMap<>();
        for(int i = 0;i<nums1.length;i++){
            int num =nums1[i];
            if(counter.containsKey(num)){
                counter.put(num,counter.get(num)+1);
            }else{
                counter.put(num,1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<nums2.length;i++){
            int num = nums2[i];
            if(counter.containsKey(num) && counter.get(num)>0){
                list.add(num);
                counter.put(num,counter.get(num)-1);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Intersection is = new Intersection();
        int[] nums1 ={4,9,5};
        int[] nums2 ={9,4,9,8,4};

        int[] arr = is.intersect2(nums1,nums2);
        System.out.println(arr.length);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
