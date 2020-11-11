public class Fibonacci {
    /** 
     * 迭代
     */
    public int fib (int n){
        if(n<2){
            return n;
        }
        int a = 0,b=1,sum=0;
        for(int i = 0; i<n;i++){
            sum = (a+b)%1000000007;
            a = b;
            b = sum ;
        }
        return a;
    }
    /**
     * DP
     */
    public int fib2 (int n){
        if(n<=1){
            return n ;
        }
        int[] f = new int[n+1];
        f[0]=0;
        f[1]=1;
        for(int i = 2;i<=n;i++){
            f[i] = (f[i-1]+f[i-2])%1000000007;
        }
        return f[n];
        
    }

    /** 
     * 迭代2
     */
    public int fib3 (int n){
        int constant = 1000000007;
        int a = 0,b=1,sum=0;
        // OR  while(--n >= 0)
        while(n-- >0){
            sum = a+b;
            a = b % constant;
            b = sum % constant;
        }
        return a;
    }
}