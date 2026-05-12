class Main {
    public static void insertionSort(int[] arr){
        
        int n = arr.length;
        
        for(int i=1;i<n;i++){
            int key = arr[i]; // store the value
            int j = i-1;
            
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j]; // movve 
                j--;
            }
            
            arr[j+1] = key;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] array = {7,3,4,5,9,8,2,1,0};
        insertionSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}