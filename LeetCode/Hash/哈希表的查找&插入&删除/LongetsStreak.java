/**
 * leetcode 128 最长连续序列
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums ) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLength++;
                }
                longest = Math.max(curLength,longest);
            }
        }
        return longest;
    }
}