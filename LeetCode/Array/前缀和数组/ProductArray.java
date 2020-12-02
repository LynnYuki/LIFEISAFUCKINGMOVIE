/**
 * leetcode 238 除自身以外数组的乘积
 */
 class Solution {
     //暴力法超时
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
          int product = 1;
          for (int j = 0;j < nums.length; j++) {
              if (nums[j] != nums[i] || j != i) {
                  product*=nums[j];
                  res[i] = product;
              }
          }
      }
      return res;
    }
    // 对于给定索引 i，我们将使用它左边所有数字的乘积乘以右边所有数字的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        //索引0 左边没有元素 乘积为1
        left[0] = 1;
        //索引nums.length - 1右边没有元素 乘积为1
        right[nums.length - 1] = 1 ;

      for (int i = 1; i < nums.length; i++) {
          left[i] = left[i - 1] * nums[i-1];
      }
      for (int j = nums.length - 2; j >= 0; j--) {
          right[j] = right[j + 1] * nums[j + 1];
      }
     // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
      for (int k= 0; k < nums.length; k++) {
          res[k] = left[k] * right[k];
      }
      return res;
    }

    //法二空间优化
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }

}