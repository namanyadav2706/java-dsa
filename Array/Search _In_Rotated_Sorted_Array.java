class Solution {
    // In an rotaed sorted array, one of the half is always sorted, we just need to find which half is sorted and where the target is and needs to update the start and end according to it.
    public int search(int[] arr, int t) {
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==t){
                return mid;
            }

            if(arr[start] <= arr[mid]){
                //left is sorted
                if(t >= arr[start] && t <= arr[mid]){
                    // target is in left
                    end = mid-1;
                }else{
                    // target is in right
                    start = mid+1;
                }
                 
            }else{
                // right is sorted
                if(t >= arr[mid] && t <= arr[end]){
                    // target is in right
                    start = mid+1;

                }else{
                    // target is in left
                    end = mid-1;

                }
            }
        }
        return -1;
    }
}