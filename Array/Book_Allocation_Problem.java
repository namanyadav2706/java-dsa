class Solution {
    // the intuition is, select the range of ans and then discard the one half and at the end reach the target answer
    // start = 0, or largest ele in the array
    // end = sum of all elements
    // find the mid, and check if allocation is posiible or not
    // if possible: 
    // else:
    public static boolean isValid(int[] arr, int k, int n, int maxPages){
        
        int st = 1; int pages = 0;
        for(int i=0;i<n;i++){
            
            if(arr[i]>maxPages) return false; // this condition can be avoided by chooseing start value as the largest ele
            
            if(pages + arr[i] <= maxPages){ // check allocation to same student possible
                pages += arr[i];   // if yes, add the pages
            }else{  
                st++;pages = arr[i];  // if not, next student
            }
        }
        
        // if allocated student are greater than the given student return false (allocation not possible)
        if(st>k){
            return false;
        }
        
        return true;
    }
    
    
    public static int findPages(int[] arr, int k) {
        
        int n = arr.length;

        // if books are less than students
        if(k>n) return -1;
        
        // finding the right side range (i.e sum of all pages)
        int sum = 0;
        for(int e: arr){
            sum += e;
        }
        
        int start = 0; int end = sum;
        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(isValid(arr,k,n,mid) == true){  // if allocation is possible then smaller answer can be possible in left
                ans = mid;
                end = mid -1;
            }else{                      // if allocation is not possible at mid then there is not chance it will be possible for any number smaller then mid
                start = mid+1;          // because if you cannot distribute 100 pages in 10 students with limit of 5, then it is also not possible to distribute 100 pages in 10 students with limit of less than 5.
            }
        }
        
        return ans;
        
    }
}