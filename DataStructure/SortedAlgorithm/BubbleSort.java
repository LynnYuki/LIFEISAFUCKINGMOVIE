/**
 * 普通冒泡排序
 */
public int[] BubbleSort(int[] nums) {
    if(nums == null || nums.length < 2) {
        return nums;
    }
    int temp = 0;
    //n个数需要比较n-1趟
    for (int i = 0; i < nums.length - 1; i++) {
        //每趟需要比较n-i次
        for(int j = 0; j < nums.length - 1 - i) {
            if (nums[j] > nums[j+1]) {
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
    return nums;
}
//优化冒泡排序
public int[] BubbleSort(int[] nums) {
    if(nums == null || nums.length < 2) {
        return nums;
    }
    int temp = 0;
    //标识是否进行过交换
    boolean flag = false;
    //n个数需要比较n-1趟
    for (int i = 0; i < nums.length - 1; i++) {
        //每趟需要比较n-i次
        for(int j = 0; j < nums.length - 1 - i) {
            if (nums[j] > nums[j+1]) {
                //记录是否发生交换
                flag = true;
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
        //在一趟排序中一次都没发生交换
        if (!flag) {
            break;
        } else {
        //重置flag
            flag = false;
        }
    }

    return nums;
}