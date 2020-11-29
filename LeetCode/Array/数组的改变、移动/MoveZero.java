/**
 * leetcode 283 移动0
 */

class Solution {
    //遍历法
    public void moveZeroes(int[] nums) {
        int zeronums = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    zeronums++;
                }
                if(nums[i]!=0 && zeronums!=0){
                    nums[i-zeronums]=nums[i];
                    nums[i]=0;
                }
            }
    }
    //快慢双指针
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}