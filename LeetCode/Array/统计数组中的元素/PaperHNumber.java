/**
 * leetcode 274 H 指数
 */

 class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        //倒序遍历
        while (i < citations.length && citations[citations.length - 1 -i] > i) {
            i++ ;
        }
        return i;
    }
}