package simple;
/*
第121题 简单
 */
public class MaxProfit {
    public int maxProfit(int[] prices){
        if(prices.length==0){
            return 0;
        }
        int pay = prices[0];
        int profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<pay){
                pay = prices[i];
            }
            profit = Math.max(prices[i]-pay,profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        int[] prices ={1,2};
        System.out.println(mp.maxProfit(prices));
    }
}
