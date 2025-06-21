class Solution {
    // for(int i=0;i<n;i++){
    //         if(s.charAt(i) == ' ' && s.charAt(i-1) != ' '){
    //             String word = s.substring(start,i);
    //             if(ans.length()>0){
    //                 ans = word + " " + ans;
    //             }else{
    //                 ans = word;
    //             }
    //         }if(s.charAt(i) == ' ' && s.charAt(i+1) != ' '){
    //             start = i+1;
    //         }if(s.charAt(i) == ' ' && s.charAt(i-1) == ' '){
    //             continue;
    //         }else{
    //             continue;
    //         }
    //     }
    //     if(ans.length()>0){
    //         ans = s.substring(start)+" "+ans;
    //     }else{
    //         ans = s.substring(start);
    //     }
    // }
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public String reverseWords(String s) {
        s = s.trim();   // removing the spaces in start and end 
        s = reverseString(s); // reversing the whole string to correct the order in the output(but the individual words are reversed)
        int n = s.length();
        String ans = "";
        
        for(int i=0;i<n;i++){
            // detecting the word(sequence of character without space)
            String word = "";
            while(i<n && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }

            word = reverseString(word);  // correcting the reversed word

            // only concatinating the valid words(ignoring the spaces in between)
            if(word.length()>0){
                ans = ans + " " + word;
            }

        }
        return ans.trim();  // again removing extra space in the front
    }
}