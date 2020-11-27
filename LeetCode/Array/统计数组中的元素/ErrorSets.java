/**
 * leetcode 645 错误的集合
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1;
        //初始化为1考虑第一项为重复项的情况
        int miss = 1;
        int[] res = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                dup = nums[i];
            } else if (nums[i] - nums[i-1] > 1) {
                miss = nums[i-1] + 1;
            }
        }
        res[0] = dup;
        //考虑最后一项为重复项的情况
        res[1] = nums[nums.length -1] != nums.length ? nums.length : miss ;
        return res;
    }
}