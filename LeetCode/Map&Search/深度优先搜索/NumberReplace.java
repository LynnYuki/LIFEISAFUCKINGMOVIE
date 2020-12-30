/**
 * leetcode 397 整数替换
 */
class Solution {
    //递归
    public int integerReplacement(int n) {
        return (int)func((long)n);
    }
    public long func (long n ) {
        if (n == 1) {
            return 0;
        }
        if(n % 2 == 0) {
            return 1 + func(n/2);
        } else {
            return 1 + Math.min(func(n+1),func(n-1));
        }
    }
}