package simple;
/*
第70题 简单
 */
import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    /*
    方法1：递归法
     */
    public int climbStairs(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }
    /*
    方法2，备忘录法
     */
    public int climbStairs_2(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        Map<Integer, Integer> map = new HashMap<>();

        if(map.containsKey(n)){
           return map.get(n);
        }else{
            int value = climbStairs_2(n-1)+climbStairs_2(n-2);
            map.put(n,value);
            return value;
        }
    }
    /*
    方法3：自底向上法
     */
    public int climbStairs_3(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        int pre1=1;
        int pre2=2;
        int res=0;
        for(int i =3;i<=n;i++){
            res = pre1+pre2;
            pre1=pre2;
            pre2=res;
        }
        return res;
    }


    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
//        System.out.println(c.climbStairs(41));
//        System.out.println(c.climbStairs_2(41));
        System.out.println(c.climbStairs_3(44));
    }
}
