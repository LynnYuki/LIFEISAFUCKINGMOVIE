/**
 * 选择排序 O(n^2)
 */

 public void selectSort(int[] nums) {
     if (nums == null || nums.length < 2) {
         return nums;
     }
     //需要进行n-1趟排序
     for (int i = 0; i < nums.length - 1 ; i++) {
         //记录最小值的下标
         int minIndex = i;
         //假设最小值为当前下标的值
         int min = nums[i];
         for (int j = i + 1;j < nums.length; j++) {
             //如果有更小的值
             if (min > nums[j]) {
                 //重新记录最小值下标
                 minIndex = j;
                 min = nums[j]
             }
         }
         //发生了交换才移动最小值到前面
         if(minIndex != i) {
             //交换最小值
             nums[minIndex] = nums[i];
             nums[i] = min;
         }
     }
 }