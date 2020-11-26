/**
 * 剑指 Offer 42. 连续子数组的最大和
 */

 class Solution {
     //动态规划 直接在原数组修改。
    public int maxSubArray(int[] nums) {
        int sums = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            } else {
                nums[i] += 0;
            }
            sums = Math.max(sums,nums[i]);
        }
        return sums;
    }

    //不允许修改原数组 dp[i]只和dp[i-1]有关,所以用两个参数存储循环过程中的dp[i]和dp[i-1]的值即可，空间复杂度也为O(1)
    public int maxSubArray(int[] nums) {
        int sums = nums[0];
        //记录dp[i-1]的值
        int before = 0;
        //记录dp[i]的值
        int cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            if (before > 0) {
                cur += before;
            } 
            if (cur > sums ) {
                sums = cur;
            }
           before = cur;
        }
        return sums;
    }
}
}