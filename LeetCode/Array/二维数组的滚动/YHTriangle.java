/**
 * leetcode 118 杨辉三角
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList();
        } 
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                //第一个位置和最后一个位置的元素为1
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                //上一行的元素进行相加
                    sub.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(sub);
        }
        return res;
    }
}