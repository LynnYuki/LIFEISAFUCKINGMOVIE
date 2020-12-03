/**
 * leetcode 189旋转数组
 */

class Solution {
    //额外数组空间
    public void rotate(int[] nums, int k) {
        if(nums.length == 0) {
            return ;
        }
        int [] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int position = (i + k) % nums.length;
            res[position] = nums[i]; 
        }
        for (int j=0; j < res.length; j++) {
            nums[j] = res[j];
        }
    }
    //三次反转
     public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse (int[] nums,int start,int end) {
        for (; start < end; start++,end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        // while (start < end) {
        //     int temp = nums[start];
        //     nums[start] = nums[end];
        //     nums[end] = temp;
        //     start ++;
        //     end --;
        // }
    }
}