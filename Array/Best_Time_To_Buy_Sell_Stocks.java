class Best_Time_To_Buy_Sell_Stocks {
    public static int bestTimeToBuySellStocks(int[] arr){
        
        // In this approach we will consider to sell stock each day and keep track for maximum difference
        int n = arr.length;
        int max_profit = 0;
        int buying = arr[0];
        
        for(int i=1; i<n;i++){
            int profit = arr[i] - buying;
            max_profit = Math.max(max_profit, profit);
            buying = Math.min(buying, arr[i]);
        }
        return max_profit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,2,4,1,3,6,4,5};
        int ans = bestTimeToBuySellStocks(arr);
        System.out.println(ans);
    }
}