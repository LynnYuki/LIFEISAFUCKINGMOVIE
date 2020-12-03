/**
 * leetcode 396 旋转数组
 */
 class Solution {
     //动态规划
    // 可以看出：
    // F[1] = F[0] + sum - nA[n-1];
    // 很容易得出
    // F[k]= F[k-1] + sum - nA[n-k]; (k>0 && k<n)

    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int len = A.length;
        int p0 = 0,p1;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            p0 += i*A[i];
        }
        int max = p0;
        for (int i = 1; i < len; i++) {
            p1 = p0 + sum -len * A[len - i];
            max = p1 > max ? p1 : max;
            p0 = p1;
        }
        return max;
    }
}