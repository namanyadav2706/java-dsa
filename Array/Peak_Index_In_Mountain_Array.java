class Solution {
    //Binary search
    // condition for target:  prev < target < next
    // how to decide where is target: if mid-1 < mid < mid (means increase order) then 'target' is in right else 'target' is in left
    // Other findings: there is always increasing order in left of target and decrease in right of target
    // In the questions of binary search: 1) find the mid 2) check if mid is target or not 3) If mid is target return it else find how you can decide wether target is in left or right(so that you can neglect the other half)
    
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length -2;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]> arr[mid-1] && arr[mid]> arr[mid+1]){
                return mid;
            }

            if(arr[mid]>arr[mid-1]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }
}