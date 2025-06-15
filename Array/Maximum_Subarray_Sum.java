class Maximum_Subarray_Sum{
    public static int maximumSubarraySum(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        int current_sum = 0;
        for(int i=0;i<n;i++){
            current_sum += arr[i];
            
            if(current_sum>maxSum){
                maxSum = current_sum;
            }
            // reset in the end bcoz of all negative elements case
            if(current_sum<0){
                current_sum = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {3,-6,2,5,-4,11,6,-7,4};
        int ans = maximumSubarraySum(arr);
        System.out.println(ans);
    }
}