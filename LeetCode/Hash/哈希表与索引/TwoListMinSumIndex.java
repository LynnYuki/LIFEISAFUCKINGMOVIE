/**
 * leetcode 599 两个列表的最小索引总和
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        //存储列表元素及其下标值
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        List<String> res = new ArrayList<>();
        //将预设的最小值设置为int的最大值方便比较更小值
        int min_sum = Integer.MAX_VALUE, sum;
        for (int i = 0; i < list2.length; i++) {
            //如果map中包含list2中的元素
            if (map.containsKey(list2[i])) {
                //计算下标和
                sum = i + map.get(list2[i]);
                //比较
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[i]);
                    min_sum = sum;
                } else if (sum == min_sum) {
                    res.add(list2[i]);
                }
            }
        }
        //按格式输出
        return res.toArray(new String[res.size()]);
    }
}