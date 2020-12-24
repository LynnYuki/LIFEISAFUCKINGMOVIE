/** 
 * leetcode 525 连续数组
 */
class Solution {
    //用+1 -1来计算0和1元素的相对个数
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int count = 0;
        //存储 count值以及在数组中出现的下标
        Map<Integer,Integer> map = new HashMap<>();
        //初始值表示count为0的时候下标为-1
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            //如果元素为0 count - 1 ,元素为1 count + 1
            count = count + (nums[i] == 0 ? -1 : 1);
            //如果该count值曾经出现过
            if (map.containsKey(count)) {
                //计算当前下标i值到上一次出现的长度
                maxLen = Math.max(maxLen,i - map.get(count));
            } else {
                map.put(count,i);
            }
        }
        return maxLen;
    }
}