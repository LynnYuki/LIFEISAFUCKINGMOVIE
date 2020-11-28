/**
 * leetcode 41 缺失的第一个最小正整数
 */

 class Solution {
     //HashSet 额外空间复杂度为O(N)
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hash.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

    //数组原地Hash 空间复杂度为O(1) 缺失的一个最小正整数肯定在[1,N+1]范围内
       public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] -1]) {
                //交换nums[i] 与nums[nums[i] - 1]的值
                int temp = nums[nums[i] - 1] ;
                nums[nums[i] -1] = nums[i] ;
                nums[i] = temp;
            }
        }
        //交换后比较 num[i]对应的值是否为下标 i+1 不等则说明缺失。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //如果全部位置都出现则N+1是未出现的最小正整数
        return nums.length + 1;
    }
}