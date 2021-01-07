/**
 * 快速排序O(n)
 */

 public void quickSort(int[] arr, int start, int end) {
      if (start < end) {
          //把数组中的第一个数字作为基准数字
          int standard = arr[start];
          //记录需要排序的下标
          int low = start;
          int high = end;
          //循环找出比基准数字打的数和比基准数字小的数
          while (low < high) {
              //如果右边的数字比标准数字大则high--
              while (low < high && standard <= arr[high]) {
                  high--;
              }
              //如果右边数字大于基准数字把low下标的值替换high下标的值,即将右边小于基准数的值移到基准数的左边
              arr[low] = arr[high];
              //如果左边的数字比基准数字小则low++
              while (low < high && standard >= arr[low]) {
                  low++;
              }
              //如果左边边数字于基准数字把high下标的值替换low下标的值,即将左边大于基准数的值移到基准数的右边
              arr[high] = arr[low];
          }
          //当low == high 把standard的值复制到low或high下标处
          arr[low] = standard;
          //处理所有小于基准数字的部分
          quickSort(arr, start, low);
          //处理所有大于基准数字的部分
          quickSort(arr, low + 1, end);
      }
    }