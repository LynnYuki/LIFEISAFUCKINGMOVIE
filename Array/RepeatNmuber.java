/**
 * 剑指Offer 03 数组中重复的数字
 */
 class Solution {
     //超时算法 双层循环
    public int findRepeatNumber(int[] nums) {
       for(int slow = 0;slow<nums.length;slow++){
         for(int fast = slow+1;fast<nums.length;fast++){
           if(nums[slow]==nums[fast]){
               return nums[slow];
           } 
         }
       }
        return -1;
    }
    // 哈希集合
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int i=0;i<nums.length;i++) {
            if (!set.add(nums[i])) {
                repeat = nums[i];
                break;
            }
        }
        return repeat;
    }
}
