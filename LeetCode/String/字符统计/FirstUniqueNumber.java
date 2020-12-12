/**
 * leetocde 387. 字符串中的第一个唯一字符
 */
 class Solution {
     //逐一比较每个字符和其他字符是否相同,返回第一个遍历到字符串末尾的字符的下标i
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        for (int i = 0 ,j; i < s.length(); i++) {
            for(j = 0; j < s.length();j++) {
                if(i == j) {
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)) {
                    break;
                }
            }
            if (j == s.length()) {
                return i;
            }
        }
        return -1;
    }
}