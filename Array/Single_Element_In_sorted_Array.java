class Solution{
    public int singleNonDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        if(start == end){
            return arr[0];
        }
        while(start<=end){
            if(start == end){
                return arr[start];
            }
            int mid = start + (end-start)/2;
            if(mid == start && start==0){
                return arr[start];
            }
            if(mid== end && end == arr.length-1){
                return arr[end];
            }

            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            
            if(mid % 2 == 1){
                //mid at odd
                if(arr[mid-1] == arr[mid]){//mid-1 is same,pair start from even
                    start = mid+1; //so, target is in right
                }else{
                    end = mid-1;
                }
            }else{
                //mid at even
                if(arr[mid] == arr[mid-1]){//mid-1 is same,pair start from odd
                    end = mid-1;  //so, target is in left
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    // Another way to see it
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        if(n == 1) return arr[0];

        while(start<=end){
            
            int mid = start + (end-start)/2;

            if(mid == 0 && arr[0] != arr[1]) return arr[mid];  // if target is at 0
            if(mid == n-1 && arr[n-1] != arr[n-2] ) return arr[mid]; // if target is at n-1
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) return arr[mid];  // if target is at mid
            
            // if mid is at even number, then the arrays in left and right both are of even size
            // so now we need to find where is the duplicate of mid
            // if it is in left, then target is also in left bcoz now in the left array(which is even) duplicates pair(even) + target + mid's dupicate 
            if(mid % 2 == 0){ // even
                if(arr[mid] == arr[mid-1] ){
                    end = mid -1;
                }else{
                    start = mid+1;
                }
            

            // Similarly if the mid is at odd, then the arrays in left and right both are of odd size
            // so now we need to find where is the duplicate of mid
            // if it is in the left, it means target is in right becoz now the left array(odd) duplicates pair(even) + mid's duplicate
            // but in the right, duplicates pair(even) + target
            }else{ //odd
                if(arr[mid] == arr[mid-1]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
                
            }
        }
        return -1;
    }
}