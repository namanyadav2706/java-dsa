class Pair_Sum{

    public static void pairSum(int[] arr, int target){
        int n = arr.length;
        
        int i = 0; int j = n-1;
        while(i<j){
            
            if(arr[i]+arr[j]>target){
                j--;
            }else if(arr[i]+arr[j]<target){
                i++;
            }else{
                System.out.println(arr[i]+" "+arr[j]);
                break;
            }
        }
        return;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,12,16};
        pairSum(arr, 16);
        System.out.println("Try programiz.pro");
    }
    
}