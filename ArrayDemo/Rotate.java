package demo;
/*
189题
 */
public class Rotate {
    //逆置函数
    public void reverse(int[] num,int h,int t){
        for(int i=h,j=t;i<=j;i++,j--){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
//        for(int n:num){
//            System.out.println(n);
//        }
    }
    /*
    我的第一种解法：通过观察发现，右移操作相当于从后按照k将数组分成两部分，两部分做出位置的调整即可
    如{1，2，3，4，5，6，7} k =3时结果为{5，6，7，1，2，3，4}
    相当于将{5,6,7}与{1,2,3,4}调整位置
    可以通过将整个数组逆置得到{7，6，5，4，3，2，1}
    再按照k分成两个子数组，分别逆置，则完成{5，6，7|1，2，3，4}
     */
    public void rotate1(int[] nums,int k){
        //如果k大于数组长度，对k取模，结果相同
        if(k >= nums.length){
            k = k % nums.length;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
//        for (int i:nums){
//            System.out.println(i);
//        }
    }
    /*
    第二种解法可以先分别逆置，再全部逆置
     */
    public void rotate2(int[] nums,int k){
        if(k > nums.length){
            k = k % nums.length;
        }
        reverse(nums,0, nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);

        for (int i:nums){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        int[] num ={1,2,3,4,5,6,7};
        Rotate r = new Rotate();
        r.rotate2(num,3);
    }
}
