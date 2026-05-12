class Main {
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int partition(int[] arr, int start, int end){
        int i = start-1;
        int pivot = arr[end];
        for(int j=start;j<end;j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,end);
        return i;
    }
    
    public static void quickSort(int[] arr, int start, int end){
        if(start>=end) return;
        int pivot = partition(arr, start, end);
        
        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] array = {7,3,4,5,9,8,2,1,0};
        quickSort(array, 0, 8);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}