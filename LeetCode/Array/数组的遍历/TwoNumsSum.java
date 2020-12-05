/**
 * leetcode 1 两数之和
 */
class Solution {
  //暴力法
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[2];
        }
       
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <nums.length; j++ ) {
            if (nums[i] + nums[j] == target) {
                res[0] =i;
                res[1] = j;
              }
            }
        }
        return res;
    }
    //hash
    public int[] twoSum(int[] nums, int target) {
      if (nums.length < 2) {
            return new int[2];
        }
       Map<Integer,Integer> hash = new HashMap<>();
        int res[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
          if (hash.containsKey(target-nums[i])) {
               res[0] =  hash.get(target-nums[i]);
               res[1] =i;
          }
          hash.put (nums[i],i);
        }
        return res;
    }
}