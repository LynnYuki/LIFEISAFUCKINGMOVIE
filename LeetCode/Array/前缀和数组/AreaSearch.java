/**
 * leetcode 303 区域和检索
 */

//暴力法 超时
 class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        int res = 0;
        for (; i <= j; i++) {
            res += this.nums[i];
        }
        return res;
    }
}

//缓存
// 让我们将 sum[k]sum[k] 定义为 nums[0⋯k−1] 的累积和（包括这两个值）：
// 现在，我们可以计算 sumrange 如下： sumrange（i，j）=sum[j+1]−sum[i]
class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int [nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[ i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[ j + 1] - sum[i];
    }
}