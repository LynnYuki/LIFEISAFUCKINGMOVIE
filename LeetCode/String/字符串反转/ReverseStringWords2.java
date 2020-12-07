/**
 * leetcode 151 翻转字符串里的单词
 */
class Solution {
    //库函数 split()分割多个空格会出现“”空元素
    public String reverseWords(String s) {
        s = s.trim();
        String[] s2 = s.split(" ");
        StringBuilder stb = new StringBuilder();
        for (int i = s2.length - 1; i >= 0; i--) {
            if(s2[i].equals("")) {
                continue;
            }
            stb.append(s2[i] + " ");
        }
        return stb.toString().trim();
    }
    //双指针
     public String reverseWords(String s) {
        s = s.trim();
        int slow = s.length() - 1;
        int fast = s.length() - 1;
        StringBuilder res = new StringBuilder();
        while (fast >= 0) {
            while (fast >= 0 && s.charAt(fast) != ' ') {
                fast --;
            }
            res.append(s.substring(fast + 1,slow + 1) + ' ');
            while (fast >=0 && s.charAt(fast) == ' '){
                fast --;
            }
            slow = fast;
        }
        return res.toString().trim();
    }

}