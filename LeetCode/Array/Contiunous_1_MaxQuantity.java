/**
 * 485. 最大连续1的个数
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 1) {
                count ++;
            } else {
                maxCount = Math.max(maxCount,count);
                count = 0;
            }
        }
        return count > maxCount ? count : maxCount;
    }
}