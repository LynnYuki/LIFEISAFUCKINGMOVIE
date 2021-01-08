/**
 * 归并排序
 */

 public void mergeSort(int[] nums,int left,int right){
     //递归结束的条件 分解到只剩一个数字时left = right
     if(left < right){
         int mid = left + (right - left) / 2;
         //左递归分解
         mergeSort(nums,left,mid);
         //右递归分解
         mergeSort(nums,mid + 1,right);
         //合并
         merge(nums,left,mid,right);
     }

 }

 public void merge(int[]nums, int left,int mid ,int right){
     //临时存放合并序列的数组
     int[] temp = new int[right - left + 1];
     //左边有序序列的左边界
     int i = left;
     //右边有序序列的起始边界
     int j = mid + 1;
     //指向temp数组的当前索引
     int t = 0;
    //先把左右两边有序序列按照规则填充到temp数组，直到某一边序列填充完毕
    while (i <= mid && j <= right) {
        //如果左边有序序列小于等于右边序序列的当前元素
        if(nums[i] <= nums[j]) {
            //将较小值copy到temp里面
            temp[t] = nums[i];
            i++;
        }else {
            temp[t] = nums[j];
            j++;
        }
        t++;
    }
    //把剩余一边的数据依次全部填充到temp
    //左边有剩余
    while (i <= mid) {
        temp[t] = nums[i];
        t++;
        i++;
    }
    //右边有剩余
    while (j <= right) {
        temp[t] = nums[j];
        t++;
        j++;
    }
    //将temp拷贝到nums
    t = 0;
    int tempLeft = left;
    while (tempLeft <= right) {
        nums[tempLeft] = temp[t];
        t++;
        tempLeft++;
    }
 }