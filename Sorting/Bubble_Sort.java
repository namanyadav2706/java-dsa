class Main {
    public static void bubbleSort(int[] arr){
        
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] array = {7,3,4,5,9,8,2,1,0};
        bubbleSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}