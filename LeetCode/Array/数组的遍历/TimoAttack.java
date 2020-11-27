/**
 * 495. 提莫攻击
 */
 class Solution {
     //考虑相邻两个攻击时间点 A[i] 和 A[i + 1] 以及中毒持续时间 t，如果 A[i] + t <= A[i + 1]，那么在第 i + 1 次攻击时，
     //第 i 次攻击造成的中毒的持续时间已经结束，即持续时间为 t；如果 A[i] + t > A[i + 1]，那么在第 i + 1 次攻击时，
     //第 i 次攻击的中毒仍然在持续，由于中毒状态不可叠加，因此持续时间为 A[i + 1] - A[i]。
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int sumTime = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            sumTime += Math.min(timeSeries[i] - timeSeries[i-1], duration);
        }
         return sumTime + duration;
    }
}