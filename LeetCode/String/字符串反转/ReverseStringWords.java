
/**
 * leetcode 557 反转字符串中的单词
 */
class Solution {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //判断是否到最后一个元素，end边界则为i
            if (i == s.length() - 1) {
                end = i;
                reverseChar(a, start, end);
            } else {
                end = i - 1;
                if (a[i] == 32) {
                reverseChar(a, start, end);
                start = i + 1;
                    }   
                }
            }
        return new String(a);
    }
    public void reverseChar (char[] a,int start,int end) {
         while (start < end) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
            }
    }
}