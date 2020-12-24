/**
 * leetcode 523 连续的子数组和
 */
class Solution {
    //设位置 j < i : 
    // 0 到 j 的前缀和 preSum1 = 某常数1 * k + 余数1
    // 0 到 i 的前缀和 preSum2 = 某常数2 * k + 余数2
    // 当找到 余数1 等于 余数2时， 则 j + 1 到 i 的连续和 = preSum2 - preSum1 = (某常数2 - 某常数1) * k， 必为 k 的倍数， 返回true
    // map的key为sum%k value 为index
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //初始化
        map.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //求余数
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum,i);
            }   
        }
        return false;
    }
}