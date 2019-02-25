package simple;

public class CountPrimes {
    /*
    利用质数的规律 除了2，3以外，所有质数都只可能出现在6的倍数的左右位置，因此不在左右位置的肯定不是质数，对于左右位置再进行判断是否存在因数
    （因为一个数如果可以因数分解，那么因子一定一个大于sqrt(n) 一个小于sqrt(n) 只要判断到sqrt(n)就可以了)
    但该方法运行时间过长，需要改进
     */
    public int countPrimes(int n){
        int count =0;
        for(int i = 2;i<n;i++){
            if(isPrimes(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrimes(int num){
        if(num==2||num==3) return true;
        if(num%6!=1&&num%6!=5)return false;
        int temp = (int)Math.sqrt(num);
        for(int i = 5;i<=temp;i++){
            if(num%i==0||num%(i+2)==0)return false;
        }
        return true;
    }


    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(30));

    }
}
