/**
 * leetcode 628 三个数的最大乘积    
 */
 class Solution {
    public int maximumProduct(int[] nums) {
        //初始值 求前几大值时赋值MIN_VALUE;
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int thrid = Integer.MIN_VALUE; 
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        if (nums.length == 3) {
            return nums[0]*nums[1]*nums[2];
        }   
        for (int num : nums) {
            //找出最大的三个数
            if (num >= first) {
                thrid = second;
                second = first;
                first = num;
            } else if (num >= second && num < first) {
                thrid = second;
                second = num;
            } else if (num < second && num >= thrid) {
                thrid  = num;
            }
            //找出最下的两个负数
            if (num <= firstMin) {   
                secondMin = firstMin;
                firstMin = num;

            } else if (num > firstMin && num <= secondMin) {
                secondMin = num;
            }
        }
        //返回最小的两个负数和最大正数的乘积 与 前三大正数乘积较大的一个值
        return Math.max(first*second*thrid,firstMin*secondMin*first);
    }
}