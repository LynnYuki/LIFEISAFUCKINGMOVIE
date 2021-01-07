/**
 * 插入排序 O(n^2)
 */
 
 public void insertSort (int[] nums) {
     //第一个数作为有序列，从第二个数开始
     for (int i = 1; i < nums.length; i++) {
        //待插入有序列的值
        int insertVal = nums[i];
        //待插入有序列的位置下标
        int insertIndex = i - 1;
        //保证插入位置下标大于等于0，比较插入值和插入位置的值大小
        while (insertIndex >= 0 && insertVal < nums[insertIndex]) {
            //将插入位置的值后移一位
            nums[insertIndex + 1] = nums[insertIndex];
            //插入位置下标减一继续向前查找是否有更小的插入位置的值
            insertIndex -- ;
        }
        //跳出while之后将插入值插入到找到的位置
        nums[insertIndex + 1] = insertVal;
     } 
 }