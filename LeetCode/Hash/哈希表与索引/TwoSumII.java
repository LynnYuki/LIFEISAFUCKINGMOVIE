/**
 * leetcode 167 两数之和II
 */
class Solution {
    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else if ( sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }
    //哈希表
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length;i++) {
            if (map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]);
                res[1] = i + 1;
            }
            map.put(numbers[i],i+1);
        }
        return res;
    }
}