/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
class Solution {
    //二分查找左右边界值相减
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lb = 0;
        int rb = 0;
        //查找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
             return 0;
        }
        lb = left; 
        //查找右边界
        left = 0; right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        rb = right;
        return rb-lb+1;
    }
}