package demo;
/*
第217题
 */
public class ContainsDuplicate {
    /*
    归并排序
    利用一个辅助数组进行排序
     */
    public void sort(int[] nums){
        int[] temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
    }

    /*
    分
    将数组2分
    然后逐步合并
     */
    public void sort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(nums,left,mid,temp);
            sort(nums,mid+1,right,temp);
            merge(nums,left,mid,right,temp);
        }
    }
    /*
    治
    合并的过程，i,j分别指向两个待合并数组的初始元素，t为temp数组的下标
    当i,j都没有到数组末尾时，循环
     两个数组进行比较，将较小的元素放入temp数组后，小数组的下标递增
     一个数组遍历完，另一个数组剩下的元素则放在temp后边
     最后将temp复制到原数组中
     */
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
        while(left<= right){
            nums[left++] = temp[t++];
        }
    }

    /*
    采取了先排序后检测的方法，排序采用归并排序（自己实现），时间复杂度O(log n),空间复杂度O(n)
    排序后如果有重复元素则表现为相邻两个数字相等。

    注：也可使用Arrays.sort() :)
     */
    public boolean containsDuplicate(int[] nums){
        if(nums.length<=0){
            return false;
        }
        sort(nums);
        int dup = nums[0];
        boolean flag = false;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=dup){
                dup = nums[i];
            }else{
                flag = true;
            }
        }
        return flag;
    }

    /*
    该解法为2ms通过解法，但其实并不对，这个方法是针对了先增后减的数组，对于先减后增的数组并不能检测。
    如{5，4，3，4，5}
     */
    public boolean containsDuplicate2(int[] nums){
            for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        break;
                    } else if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,4,5};
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate2(nums));
        System.out.println(cd.containsDuplicate(nums));
    }

}
