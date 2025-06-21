class Solution {
    // function to remove the sub-string from the main string
    public static String erase(String s, int start, int length){
        return s.substring(0,start) + s.substring(start+length);
    }

    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part) != -1){
            s = erase(s,s.indexOf(part), part.length());
        }
        return s;
    }
}