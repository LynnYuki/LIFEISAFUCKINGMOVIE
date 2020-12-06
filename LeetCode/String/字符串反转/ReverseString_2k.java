/**
 * 反转2k字符串
 */

class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        for (int init = 0; init < n; init += 2*k) {
            int start = init;
            //判断的关键 start + k - 1
            int end = Math.min(start + k - 1,n - 1);
            while (start < end) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start ++;
                end --;
             }
        }
        return new String(ch);
        
    }
}