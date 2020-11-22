/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
 class Solution {
   //直接遍历
    public int missingNumber(int[] nums) {
      //排除[0],[1]这种情况
        if (nums[0] == 1) {
            return 0;
        }
        for (int i = 0 ; i < nums.length;i++) {
            if ( nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
    // 二分法
    public int missingNumber (int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == mid) {
          left = mid + 1;
        } else if (nums[mid] != mid ) {
          right = mid - 1 ;
        }
      }
      return left;
    }
}