class Majority_Element{
    public static int majorityElement(int[] arr){
        // Moore's voting Algorithm
        int n = arr.length;
        int m = n/2 + 1;
        
        int count = 0;
        int candidate = -1;
        
        for(int i = 0; i<n;i++){
            // if count is zero, make the current as candidate
            if(count==0){
                candidate = arr[i];
            }
            // if there is the same element increment the count
            // decrement the count if there is different element
            if(arr[i] == candidate){
                count++;
            }else{
                count--;
            }
        }
        // at the end the majority element will always have minimum 1 count
        return candidate;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,1,4,4,1,4,1,4,4};
        int ans = majorityElement(arr);
        System.out.println(ans);
    }
}