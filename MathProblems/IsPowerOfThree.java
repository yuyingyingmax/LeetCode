package simple;

public class IsPowerOfThree {
    public boolean isPowerOfThree(int n){
        if(n==1)return true;
        if(n==0) return false;
        if(n%3!=0){
            return false;
        }
        if(n%3==0){
            return isPowerOfThree(n/3);
        }
        return true;
    }

    public boolean isPowerOfThree_2(int n){
        double result = Math.log(n)/ Math.log(3);
        System.out.println(result);
        if(result==(long)result){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsPowerOfThree ipot = new IsPowerOfThree();
//        System.out.println(ipot.isPowerOfThree_2(59049));
//        System.out.println(Math.log(243)/Math.log(3));
        double a = Math.log(81);
        double b = Math.log(3);
        double c = a/b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
