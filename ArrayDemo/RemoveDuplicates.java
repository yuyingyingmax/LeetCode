package demo;
/*
第26题
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] num){
        //空数组的判定
        if(num.length==0){
            System.out.println("this is a empty array!");
            return 0;
        }
        //只有一个元素的数组，不存在重复，直接返回长度
        if (num.length==1){
            return 1;
        }
        //剩下要处理长度>1的数组，注意：数组已排好序
        /*
        @param:current_number 记录新数组的数字
        @param:len记录新数组的长度
         */
        int current_number = num[0];
        int len = 1;

        /*
        从数组的第二个元素开始遍历数组，如果元素与current_number相同，则继续遍历，直到一个不相等的数字
        len既为不重复数组的长度，又是需要被覆盖的位置
        所以当我们找到一个与current_number不相等的数字时，就用这个新数字num[i]替换掉num[len]
        然后我们新数组的当前数字就为这个num[i]
        新数组的长度要+1
         */
        for(int i = 1; i<num.length;i++){
            if(num[i]!=current_number){
                num[len] = num[i];
                current_number = num[i];
                len++;
            }
        }
        /*
        输出打印
        System.out.println("now len = "+len);
        for (int n:num){
            System.out.println(n);
        }
        */
        return len;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd =new RemoveDuplicates();
        int[] num ={0,0,1,1,1,2,2,3,3,4};
        rd.removeDuplicates(num);
    }
}
