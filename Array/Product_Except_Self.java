class Solution {
    // Brute force: O(n2) nested itrate, find product of element except current "i"
    // Better: product of all other element is the product of element in left and product of element in right, so create two array which will store  product for each element in left(prefix) and in right(suffix) and then ans[i] = prefix[i] * suffix[i]
    // optimal: Do not store the prefix and suffix product in arrays, instead store prefix in ans inself and keep track of product of element in the right and keep multiplying to the prefix (i.e. stored in ans already)
    
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        // int[] prefix = new int[n];
        // int[] suffix = new int[n];
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i=1;i<n;i++){
            //prefix[i] = arr[i-1] * prefix[i-1];
            ans[i] = arr[i-1] * ans[i-1];
        }

        //suffix[n-1] = 1;
        int prod = arr[n-1];
        for(int i=n-2;i>=0;i--){
            //suffix[i] = arr[i+1] * suffix[i+1];
            ans[i] *= prod;
            prod *= arr[i];
        }

        // for(int i=0;i<n;i++){
        //     ans[i] = prefix[i] * suffix[i];
        // }

        return ans;
    }
}