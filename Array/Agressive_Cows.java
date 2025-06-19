import java.util.Arrays;
class Solution {
    // the problem is direct variation of book allocation and painters partiotion problem 
    // but a bit different also
    // lets understand the problem
    // in this we need to mind the max ans instead of min
    // so consition of left/right half will reverse; if ans is valid then go to right to find bigger ans; if not then go to left becoz it is not pssoible to arrage cow at this distance
    public static boolean isValid(int[] arr, int k, int n, int minDistance){
        
        int cows = 1; int prevCow = arr[0];
        
        for(int i=1; i<n;i++){
            if((arr[i] - prevCow) >= minDistance){  // Is it possible to keep the cow at this position by maintaining the min distance
                cows++; prevCow = arr[i];
            }
        }
        
        return cows>=k;                   // true if we can arrange all the given cows in the possible arrangements
    }
    public static int aggressiveCows(int[] stalls, int k) {

        int n = stalls.length;
        
        // sort the array, so that we can easilt track the position of prec cow the distance between them
        Arrays.sort(stalls);
        
        int start = 1; int end = stalls[n-1]-stalls[0]; int ans = -1; // min distance possible is 1, and max distance is the difference between the first cow and the last cow
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(isValid(stalls,k,n,mid) == true){  // if valid then go to right to find the max possible ans
                ans = mid;
                start = mid+1;
            }else{                        // not possible then go the left to find the answer
                end = mid-1;
            }
        }
        
        return ans;
        
    }
}