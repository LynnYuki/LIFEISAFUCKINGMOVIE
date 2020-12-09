/**
 * leetcode  28 字符串匹配
 */
 class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int n = haystack.length();
        for (int start = 0; start < n - len + 1; start++) {
            if (haystack.substring(start,start + len).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();
        if (n == 0) {
            return 0;
        }
        //注意m -n 防止越界
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}