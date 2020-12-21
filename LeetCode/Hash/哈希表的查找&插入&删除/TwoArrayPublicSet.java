/**
 * leetcode 349 两个数组的交集
 */
class Solution {
    //hash集合去重遍历比较
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : set) {
            if(set2.contains(num)) {
                temp.add(num);
            }
        }
        //遍历结果集转换为int[]
        int[] res = new int[temp.size()];
        int i = 0;
        for (int num : temp) {
            res[i++] = num;
        }

        return res;
    }
}