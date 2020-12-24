/**
 * leetcode 454 四数相加
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //将AB CD分组遍历
        Map<Integer,Integer> mapAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                //存储A[i] + B[j]的值和出现的次数
                mapAB.put(a + b,mapAB.getOrDefault(a + b,0) + 1);
             }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                //如果-(C[k]+D[m])的键出现在map中   
                if (mapAB.containsKey(-c-d)) {
                    //累加其值
                    count += mapAB.get(-c-d);
                }
            }
        }
        return count;
    }
}