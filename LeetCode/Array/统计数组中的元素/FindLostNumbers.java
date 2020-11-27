/**
 * leetcode 448 找到所有数组中消失的数字
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        //第一遍扫描 找到元素本应对应的下标 比如3 对应下标2
        for (int i = 0; i < nums.length; i++) {
            //当前索引的值可能已经被之前重复的值修改为负数
            int index = Math.abs(nums[i]) - 1;
            //如果当前下标的值为负说明已经被修改过，为正则变为相反数
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        //第二遍找到所有非负数，非负数所在的下标+1，即为缺失的数字
        for (int j = 0; j < nums.length;j++) {
            if (nums[j] > 0) {
                res.add(j+1);
            }
        }
        return res;
    }
}