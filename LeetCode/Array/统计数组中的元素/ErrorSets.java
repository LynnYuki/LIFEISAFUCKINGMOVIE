/**
 * leetcode 645 错误的集合
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1;
        //初始化为1考虑第一项为重复项的情况
        int miss = 1;
        int[] res = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                dup = nums[i];
            } else if (nums[i] - nums[i-1] > 1) {
                miss = nums[i-1] + 1;
            }
        }
        res[0] = dup;
        //考虑最后一项为重复项的情况
        res[1] = nums[nums.length -1] != nums.length ? nums.length : miss ;
        return res;
    }
    // HashMap 存储数组元素出现的次数 大于2为重复，不存在则为缺失元素
    public int[] findErrorNums(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int dup = -1;
        int miss = 1;
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                miss = i;
            }
        }
        return new int[] {dup,miss};
    }
}