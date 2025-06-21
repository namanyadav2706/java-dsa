class Solution {
    // function to compare two arrays of same size;
    public static boolean isFreqSame(int[] freq1, int[] freq2){
        for(int i=0;i<freq1.length;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        // storing the freq of s1
        for(int i=0;i<s1.length();i++){
            int index = s1.charAt(i) - 'a';
            freq[index] += 1;
        }

        for(int i=0;i<s2.length()-s1.length()+1;i++){
            int[] freq2 = new int[26];

            // storing the freq of window(same size of s1) in s2
            for(int j=0;j<s1.length();j++){
                int index = s2.charAt(i+j) - 'a';
                freq2[index] += 1;
            }

            // for(int ele:freq2){
            //     System.out.print(ele+" ");   
            // }
            // System.out.println();

            // compare freq array
            if(isFreqSame(freq,freq2)){
                return true;
            }
        }
        return false;
    }
}