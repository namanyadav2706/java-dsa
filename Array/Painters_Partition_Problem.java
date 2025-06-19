class Solution {
    // same as Book allocation problem
    // Just one difference, remove this condition: if(k>n) return -1;
    // because "Each student receives atleast one book" this kind of condition is not given in painters partition
    // so there can be some extra painters, which would not effect the result
    
    public static boolean isValid(int[] arr, int k, int n, int maxTime){
        
        int painters = 1; int time = 0;
        for(int i=0;i<n;i++){
            
            if(time + arr[i] <= maxTime){
                time += arr[i];
            }else{
                painters++;time = arr[i];
            }
        }
        
        return painters<=k;
    }
    
    public int minTime(int[] arr, int k) {
        
        int n = arr.length;
        //if(k>n) return -1;
        
        int sum = 0; int maxValue = Integer.MIN_VALUE;
        for(int e: arr){
            maxValue = Math.max(maxValue, e);
            sum += e;
        }
        
        
        int start = maxValue; int end = sum;
        int ans = -1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(isValid(arr,k,n,mid) == true){
                ans = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        
        return ans;
    }
}
