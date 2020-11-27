/**
 * leetcode 687 数组的度
 */
 class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        //遍历数组 分别存储各元素第一次出现的left边界和right边界以及出现次数
        for (int i = 0; i < nums.length; i++) {
            if (left.get(nums[i]) == null) {
                left.put (nums[i],i);
            }
            right.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0) + 1);
        }
        //cout中最大值即为度
        int degree = Collections.max(count.values());
        int res = nums.length;
        for (int num : count.keySet()) {
            //找出count中和原数组中度相同的值
            if (count.get(num) == degree) {
                res = Math.min(res,right.get(num) - left.get(num) + 1);
            }
        }
        return res;
    }
}