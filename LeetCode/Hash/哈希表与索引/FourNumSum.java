/**
 * leetcode 18 四
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        int len = nums.length;
        //升序排列
        Arrays.sort(nums);
        for (int first = 0; first < len - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //获取当前的最小值如果该值比target大则后面元素一定不满足要求
            int min1 = nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3];
            if (min1 > target) {
                break;
            }
            //获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
            int max1 = nums[first] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max1 < target) {
                continue;
            }
            //第二层循环 初始化指针指向first+1
            for (int second = first + 1; second < len - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                } 
                //定义左右指针
                int left = second + 1;
                int right = len - 1;  
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
                int min2 = nums[first] + nums[second] + nums[left] + nums[left + 1];
                if(min2 > target) {
                    break;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max2 = nums[first] + nums[second] + nums[right] + nums[right - 1];
                if (max2 < target) {
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (left < right) {
                    int sum = nums[first] + nums[second] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[first],nums[second],nums[left],nums[right]));
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        //注意second也要小于right
                        while(left < right && second < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}