class Solution {
    // Function to check if the particular character is a alphanumeric or not
    public static boolean isAlphaNumeric(char c){
        return ((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122) || ((int) c >= 48 && (int) c <= 57);
    }

    public boolean isPalindrome(String s) {
        int start = 0; int end = s.length()-1;
        while(start<end){
            if(!isAlphaNumeric(s.charAt(start))){
                start++;continue;
            }
            if(!isAlphaNumeric(s.charAt(end))){
                end--;continue;
            }

            //to lowercase the character before comparing
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }

            start++;end--;

        }

        return true;
    }
}