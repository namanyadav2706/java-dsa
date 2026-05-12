class Main {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    
    public static void permutations(int[] arr,int idx){
        if(idx == arr.length){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        
        for(int i = idx;i<arr.length;i++){
            swap(arr,idx,i);
            permutations(arr, idx+1);
            swap(arr,i,idx);
        }
        return;
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {1,2,3};
        permutations(arr,0);
    }
}