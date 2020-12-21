/**
 * leetcode 202 快乐数
 */
class Solution {
    //set去重 判断是否出现循环
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    //快慢指针判断循环链表
    public boolean isHappy(int n) {
       int slow = n;
       int fast = getNext(n);
       while(fast != 1 && slow != fast) {
           slow = getNext(slow);
           fast = getNext(getNext(fast));
       }
       return fast == 1;
    }

    //计算平方和获取下一个数
    public int getNext (int n) {
        int squareSum = 0; 
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            squareSum += d * d;
        }
        return squareSum;
    }
    
}