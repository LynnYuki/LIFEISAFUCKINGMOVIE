/**
 * leetcode 594 最长和谐子序列
 */
class Solution {
    //暴力枚举
    public int findLHS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                } else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }
            if (flag) {
                res = Math.max(count,res);
            }
         }
         return res;
    }
    //哈希表
    public int findLHS(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //存储每个元素出现的次数
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        //遍历hash表 找出x 和 x+1出现的次数
        for (int key : map.keySet()) {
            if(map.containsKey(key + 1)) {
                res = Math.max(res,map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}