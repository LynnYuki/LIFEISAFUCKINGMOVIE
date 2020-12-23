/**
 * leetcode 554 砖墙
 */
class Solution {
    //哈希表存储每一行砖块的总宽度，已经该宽度出现的次数
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            //对于每一行，我们只考虑到倒数第二块砖头的 sum 值，因为最后一块砖头的右边界不是一个衔接处。
            for (int i = 0; i < row.size() - 1; i++) {
                //计算每一行砖头宽度
                sum += row.get(i);
                //如果该宽度存在 则次数+1
                if (map.containsKey(sum)) {
                    map.put(sum,map.get(sum) + 1);
                } else {
                    map.put(sum,1);
                }
            }
         }
         //砖墙的高度
         int res = wall.size();
         //找出某宽度出现最多的次数 说明相同宽度的砖 组成的缝隙一致 则穿过的砖最少
         for (int key : map.keySet()) {
             //砖墙的高度减去缝隙数就是穿过的砖块数
             res = Math.min(res,wall.size() - map.get(key));
         }
         return res;
    }
}