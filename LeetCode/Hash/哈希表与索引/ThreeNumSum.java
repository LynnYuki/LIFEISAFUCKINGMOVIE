/**
 * leetcode 15 三数之和 
 */
class Solution {
    //排序枚举+双指针
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //枚举a
        for (int i = 0; i < n; i++) {
            //需要和上次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }
            //c的指针指向最右边
            int k = n - 1;
            // a的值取负值
            int target = -nums[i];
            //枚举b
            for (int j = i + 1; j < n; j++) {
                //需要和上次枚举的数不相同
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //保证 j指针在k的左边
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                //如果j,k相遇则跳出
                if (j == k) {
                    break;
                }
                //找到这样的等式
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}