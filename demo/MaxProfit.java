package demo;
/*
122题
 */
public class MaxProfit {
    /*
    我的解法
    逻辑：只考虑今天和明天的价格，今天<明天就算一次买入卖出
     */
    public int maxProfit(int[] prices){
        int profit = 0;

        for(int i = 0; i<prices.length-1 ; i++){
            if(prices[i]<prices[i+1]){
                profit += prices[i+1]-prices[i];
            }
        }
        return profit;
    }
/*
官方解法2：峰谷法
 */
    public int maxProfit2(int[] prices){
        int maxprofit = 0;
        int valley = prices[0];
        int peak = prices[0];
        int i =0;

        while(i<prices.length-1){
            while(i<prices.length-1 && prices[i]>=prices[i+1]){
                i++;
            }
            valley = prices[i];
            while(i<prices.length-1 && prices[i]<=prices[i+1]){
                i++;
            }
            peak = prices[i];
            maxprofit += peak-valley;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        MaxProfit mp =new MaxProfit();
        int[] prices={1,7,2,3,6,7,6,7};
        System.out.println(mp.maxProfit(prices));
    }
}
