/**
 * leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = binarySearch(nums, target, "left");
        int right = binarySearch(nums, target, "right");
        res[0] = left;
        res[1] = right;
        return res;
    }

    public int binarySearch(int[] nums, int target, String flag) {
        int left = 0;
        int right = nums.length - 1;
        if ("left".equals(flag)) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                }
            }
            if (left >= nums.length || nums[left] != target) {
                return -1;
            }
            return left;
        } else if ("right".equals(flag)) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    left = mid + 1;
                }
            }
            if (right < 0 || nums[right] != target) {
                return -1;
            }
            return right;
        }
        return -1;
    }
}