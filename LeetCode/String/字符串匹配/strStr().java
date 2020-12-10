/**
 * leetcode  28 字符串匹配
 */
 class Solution {
     //暴力匹配法 
    public int strStr(String haystack, String needle) {
        int m =haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        if(n == 0) {
            return 0;
        }
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i ++;
                j ++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == n) {
                return i - j;
            }
        }

        return -1;
    }

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

    //sunday 法
    public int strStr(String haystack, String needle) {
        if (haystack != null && haystack.equals(needle)) {
            return 0;
        }
        if(haystack == null || haystack.length() == 0) {
            return -1;
        }
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        //注意 i <= m -n
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            while (j < n && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if (j == n) {
                return i;
            } else {
                int k = n - 1;
                //注意 i + n < m
                while (k >= 0 && i + n < m && haystack.charAt(i + n) != needle.charAt(k)) {
                    k--;
                }
                //在needle中未找到匹配串最后一个字符的下一个字符
                if (k < 0) {
                    //i 指针直接跳 n 长度
                    i = i + n;
                }else {
                    //找到了则i跳 该字符在needle中最右出现到末尾的距离+1 因为for循环中的i++会自增1 所以这里不用+1
                    i = i + n -1 - k;
                }
            }
        }
        return -1;
    }
}