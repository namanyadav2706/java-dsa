class Main {
    
    public static int binarySearchItretive(int[] arr, int x){
        int n = arr.length;
        int start = 0; int end = n-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    
    // Recursive
    public static int binarySearch(int[] arr, int x, int start, int end){
        int mid = start + (end-start)/2;

        if(start>end){
            return -1;
        }
        
        if(arr[mid]==x){
            return mid;
        }
        
        int ans;
        if(arr[mid]>x){
            ans = binarySearch(arr,x,start,mid-1);
        }else{
            ans = binarySearch(arr,x,mid+1,end);
        }
        
        return ans;
        
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40, 42, 47, 67, 87, 91 };
        int ans = binarySearch(arr, 42, 0,9);
        System.out.println(ans);
    }
}