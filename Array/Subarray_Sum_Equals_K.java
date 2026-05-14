import java.util.*;

class Main {
    
    public static int subArraysSumEqualsK(int[] arr, int k){
        int n = arr.length;
        int ans = 0;
        int[] prefixSum = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            prefixSum[i] += sum;
        }
        
        for(int i=0;i<n;i++){
            if(prefixSum[i] == k){
                ans++;
            }else{
                if(map.containsKey(prefixSum[i]-k)){
                    ans += map.get(prefixSum[i]-k);
                }
            }
            
            
        map.put(prefixSum[i],map.getOrDefault(prefixSum[i],0) +1);
            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3 ,1, 1, 1, 1};
        System.out.print(subArraysSumEqualsK(arr,3));
     }
}