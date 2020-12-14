/**
 * TX 88 合并两个有序数组
 */

class Solution {
    //调用库
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i< n; i++) {
            nums1[m+i] = nums2[i]; 
        }
        Arrays.sort(nums1);
    }
    //双指针 从后向前
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //指向nums1中有数字的末尾
        int pm = m - 1;
        //指向nums2中的末尾
        int pn = n - 1;
        //指向nums1中的末尾
        int pLen = m + n - 1;
        
        while (pm >= 0 && pn >= 0) {
            //以下代码可以简化为一行 nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            //如果pm指向的值小于pn指向的值则把pn的值赋给nums1[pLen];
             if (nums1[pm] < nums2[pn]) {
                 nums1[pLen] = nums2[pn];
                 pn--;
                 pLen--;
            //如果pm指向的值大于pn指向的值则把pm的值赋给nums1[pLen];
             } else {
                 nums1[pLen] = nums1[pm];
                 pLen--;
                 pm--;
             }
        }
        //如果nums1的长度小于nums2 则把nums2剩余的值直接赋值给nums1
        System.arraycopy(nums2, 0, nums1, 0, pn + 1);

    }
}