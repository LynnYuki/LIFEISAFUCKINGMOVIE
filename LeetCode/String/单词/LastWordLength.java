/**
 * leetcode 58 最后一个单词的长度
 */
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        String[] a = s.split(" ");
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != "") {
                len = a[i].length();
                break;
            }
        }
        return len;
    }

    //从右向左遍历，遇到不是' '开始计数，直到遇到下一个' '则停止计数，返回长度
    public int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null || s.length() == 0) {
            return len;
        }
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == ' ') {
                if (len == 0) {
                    continue;
                }
                break;
            }
            len++;
        }
        return len;
    }
}