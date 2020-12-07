/**
 * leetcode 434 统计字符串中的单词数
 */

class Solution {
    public int countSegments(String s) {
        if(s.length() == 0){
            return 0;
        }
        s = s.trim();
        int count = 0;
        String[] s2 = s.split(" ");
        for (int i = 0; i < s2.length; i++) {
            if (!s2[i].equals("")) {
                count ++;
            }
        }
        return count;
    }
    // 正则表达式
     public int countSegments(String s) {
        s = s.trim();
        if (s.equals("") ) {
            return 0;
        }
        return s.split("\\s+").length;
    }

    //原地修改
      public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}