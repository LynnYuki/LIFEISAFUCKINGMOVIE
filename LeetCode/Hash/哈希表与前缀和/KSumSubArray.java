/**
 * leetcode 560 和为K的子数组
 */
class Solution {
    //暴力遍历
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k ) {
                    count++;
                }
            }
        }
        return count;
    }
    //哈希表存储前缀和以及出现次数
   // 我们考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]-k 的 pre[j] 即可
   //pre[j-1] 表示[0...j-1]的前缀和，pre[j...i]表示[j...i]的前缀和即为K pre[i] 表示[0...i]的前缀和
   //可以推出 pre[i] == pre[j-1] + pre[j...i]  
   //即 pre[j-1] = pre[i] - k
     public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int count = 0;
        int pre = 0;
        for (int num : nums) {
            pre += num;
            if (preSum.containsKey(pre - k)) {
                count += preSum.get(pre - k);
            }
            preSum.put(pre,preSum.getOrDefault(pre,0) + 1);
        }
        return count;
    }
}