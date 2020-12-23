/**
 * leetcode 219 存在重复元素
 */
class Solution {
    //维护一个size为k的哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            //如果size大于k则删除和当期下标距离为 k的元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}