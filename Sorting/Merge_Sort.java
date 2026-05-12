class Main {
    
    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while(j<=end){
            temp[k] = arr[j];
            j++;k++;
        }
        
        while(i<=mid){
            temp[k] = arr[i];
            i++;k++;
        }
        
        for(int idx = 0; idx<temp.length;idx++){
            arr[start+idx] = temp[idx];
        }
    }
    
    public static void mergeSort(int[] arr, int start, int end){
        if(start>=end) return;
        int mid = start + ((end-start)/2);
        
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        
        merge(arr, start, mid, end);
    }
    
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] array = {7,3,4,5,9,8,2,1,0};
        mergeSort(array, 0, 8);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}