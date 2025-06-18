class Solution {
    // Brute force: find all possible containers and compare their area
    // use two pointers and move the height with lower height because area will always decrease when moving the bigger height because area also depend on the lower height(while moving with upper height, the height of the container remain same and length will decrease)
    public int maxArea(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        int i=0; int j=n-1;
        while(i<j){
            int water = (j-i) * Math.min(arr[i],arr[j]);
            ans = Math.max(water, ans);
            if(arr[i]>arr[j]){
                j--;
            }else{
                i++;
            }
        }
        
        return ans;
    }
}