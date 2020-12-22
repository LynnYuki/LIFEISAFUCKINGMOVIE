/** 
 * leetcode 532 K-Diff数对 
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        if (k < 0) {
            return count;
        }
        //统计元素出现的次数
        for (int i = 0; i < nums.length; i++) {
           map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int v = entry.getValue();
            int key = entry.getKey();
            //k == 0 说明数对两元素相同 只有出现次数大于1次就有一对
            if (k == 0 && v > 1) {
               count++;
            } else if (k != 0 && map.containsKey(key - k)) {
               count++;
            }
        }
        return count;
    }
}