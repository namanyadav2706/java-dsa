import java.util.*;

public class Solution {

    public static int longestSubarrayWithSumK(int[] arr, long k) {

        int n = arr.length;
        int ans = 0;

        long[] prefixSum = new long[n];

        long sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            prefixSum[i] = sum;
        }

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {

            if(prefixSum[i] == k) {
                ans = Math.max(ans, i + 1);
            }

            if(map.containsKey(prefixSum[i] - k)) {
                ans = Math.max(ans,
                        i - map.get(prefixSum[i] - k));
            }

            // store first occurrence only
            if(!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            }
        }

        return ans;
    }
}