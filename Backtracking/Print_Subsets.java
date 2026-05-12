import java.util.*;
class Main {
    
    public static void printAllSubsets(int[] arr, int start, ArrayList subsets){
        
        if(start == arr.length){
            System.out.println(subsets);
            return;
        }
        
        subsets.add(arr[start]);
        printAllSubsets(arr,start+1,subsets);
        subsets.remove(subsets.size()-1);
        printAllSubsets(arr,start+1,subsets);
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {1,2,3,4};
        ArrayList<Integer> ans = new ArrayList<>();
        printAllSubsets(arr,0,ans);
    }
}