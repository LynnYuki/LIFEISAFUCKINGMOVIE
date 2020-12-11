/**
 * leetcode 459 重复的子串
 */

 //两个 ss 连在一起，并移除第一个和最后一个字符。如果 ss 是该字符串的子串，那么 ss 就满足题目要求。
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String sums = s + s;
        return sums.substring(1,sums.length()-1).indexOf(s) != -1;
    }
}