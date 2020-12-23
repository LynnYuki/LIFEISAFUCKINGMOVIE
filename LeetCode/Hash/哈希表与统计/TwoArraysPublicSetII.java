/**
 * leetcode 350 两个数组的交集II
 */
class Solution {
    //哈希表
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2,nums1);
        }
        //存储较短数组的元素出现次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        //遍历较长数组
        for (int num : nums2) {
            //如果包含该元素
            if (map.containsKey(num)) {
                //取出出现次数
                int count = map.getOrDefault(num,0);
                res[index++] = num;
                //出现次数减一
                count--;
                //如果出现次数大于0，更新出现次数
                if(count > 0) {
                    map.put(num,count);
                //出现次数为0则删除该元素
                } else {
                    map.remove(num);
                }
            } 
        }
        //截取正确长度的数组
        return Arrays.copyOfRange(res,0,index);
    }
}