/**
 * 剑指 Offer 57. 和为s的两个数字 
 */
class Solution {
  // 对撞指针
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int [] res = new int [2];
        while ( left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            } else if (nums[left] + nums[right] < target) {
                left ++ ;
            } else if (nums[left] + nums[right] > target) {
                right -- ;
            }
        }
        return res;
    }
  
  //Hash表遍历
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }
        for ( int num : hash) {
            int e  = target - num;
            if (hash.contains(e)) {
                return new int[] {e,num};
            }
        }
        return new int[]{};
    }
}
