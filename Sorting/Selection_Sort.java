class Main {
    public static void selectionSort(int[] arr){
        
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[min]) min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
            
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] array = {7,3,4,5,9,8,2,1,0};
        selectionSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}