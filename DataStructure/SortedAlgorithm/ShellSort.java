/**
 * 希尔排序--改进的插入排序 O(nlogn)
 */

//直接交换法速率较慢
 public void shellSort(int[] nums) {
     //将待排序数组进行分组处理
     int temp = 0;
     for (int gap = nums.length / 2; gap > 0; gap /= 2) {
         //遍历各分组的元素，增量为gap
         for (int i = gap; i < nums.length; i++) {
             for (int j = i - gap; j >= 0; j -= gap) {
                 //如果当前元素大于加上增量后的元素则交换位置
                 if (nums[j] > nums[j + gap] ) {
                     temp = nums[j];
                     nums[j] = nums[j + gap];
                     nums[j + gap] = temp;
                 }
             }
         }
     }
 }
 
 //移位法
 public void shellSort(int[] nums) {
     //分组，增量gap
     for (int gap = nums.length / 2; gap > 0; gap /= 2) {
         for (int i = gap; i < nums.length; i++) {
             //待插入值的下标
             int j = i;
             //待插入的值
             int temp = nums[j];
             if (nums[j] < nums[j - gap]) {
                 while (j - gap >= 0 && temp < nums[j - gap]) {
                     nums[j] = nums[j - gap];
                     j -= gap;
                 }
                 //跳出while循环后，插入temp的值
                 nums[j] = temp;
             }
         }
     }
 }