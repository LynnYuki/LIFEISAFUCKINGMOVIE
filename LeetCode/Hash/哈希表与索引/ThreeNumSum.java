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

// 标签：数组遍历
// 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
// 如果 nums[i]大于 0，则三数之和必然无法等于 00，结束循环
// 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
// 当 sum == 0 时，nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++
// 当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--
// 时间复杂度：O(n^2)，n 为数组长度

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) {   
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
        // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = n - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    //去重
                     while (L < R && nums[R] == nums[R - 1]) {
                         R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }  
        return res;
    }
}