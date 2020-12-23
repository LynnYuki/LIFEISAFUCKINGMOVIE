/**
 * leetcode 220 存在重复的元素II
 */
class Solution {
    //treeset 
    // 其中有一个方法 public E ceiling(E e) ，返回 treeSet 中大于等于 e 的元素中最小的元素，如果没有大于等于 e 的元素就返回 null。
    // 还有一个对应的方法，public E floor(E e)，返回 treeSet 中小于等于 e 的元素中最大的元素，如果没有小于等于 e 的元素就返回 null。

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        if (i > k) {
            set.remove((long)nums[i - k - 1]);
        }
        Long low = set.ceiling((long) nums[i] - t);
        //是否找到了符合条件的数
        if (low != null && low <= (long)nums[i] + t) {
            return true;
        }
        set.add((long) nums[i]);
    }
    return false;
}

}