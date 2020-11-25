/**
 * 剑指Offer 11 旋转数组的最小数字
 */
 class Solution {
     //快慢双指针
    public int minArray( int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
      int slow = 0;
     for (int fast = 1; fast < numbers.length; fast++) {
         if (numbers[fast] < numbers[slow]) {
             return numbers[fast];
         }
         slow = fast;
         //如果最后一个元素仍然比前一个元素大说明该数组是整体左旋返回第一个元素就是最小值
         if (fast == numbers.length - 1 &&  numbers[fast] >= numbers[slow]) {    
             return numbers[0];
         }
     }
          return -1;
    }

    //二分
     public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                right -- ;
            }
        }
        return numbers[left];
    }
}