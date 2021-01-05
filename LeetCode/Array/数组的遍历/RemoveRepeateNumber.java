/**
 * leetcode 26 删除数组中重复的项
 */
class Solution {
    //快慢双指针
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 1;fast < nums.length;fast++) {
            //如果不相等则fast赋值给slow+1
            if(nums[slow] != nums[fast]) {
                slow ++;
                nums[slow ] = nums[fast];
            }
        }
        return slow + 1;
    }
}