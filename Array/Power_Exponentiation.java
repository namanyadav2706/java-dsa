
class Power_Exponentiation {
    public static long powerExponantial(long x, long n){
        if(x==0) return 0;
        if(x==1) return 1;
        if(n==0) return 1;
        if(n==1) return x;
        if(x==-1 && n%2==0) return 1; 
        if(x==-1 && n%2==1) return -1; 
        
        //Negative power
        if(n<0){
            n = -n;
            x = 1/x;
        }
        
        long ans = 1;
        while(n>0){
            // if last digit is 1, then multiply x power in it
            if((n & 1) == 1){
                ans *= x;
            }
            // increment x by x+x and removing the unit place by right shift by one 
            x *= x;
            n >>= 1;
        }
        return ans;
        
    }
    public static void main(String[] args) {
        //int[] arr = {1,1,4,4,1,4,1,4,4};
        long ans = powerExponantial(3,34);
        System.out.println(ans);
    }
}