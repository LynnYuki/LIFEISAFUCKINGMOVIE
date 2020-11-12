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

    /**
     * 备忘录递归法
     */
    public int fib4(int n){
        if(n<2){
            return n;
        }
        int [] memo = new int[n+1];
        int result = memory(memo,n);
        return result;
    }

    public int memory (int[] memo ,int n){
        if(n<2){
            return n;
        }
        if(memo[n]!=0){
            return memo[n];;
        }
        memo[n] = memory(memo,n-1) + memory(memo,n-2);
        memo[n] % = 1000000007;
        return memo[n];
    }
}