/**
 * leet code 392 判断子序列
 */

 class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //index标记查找字符c的相对存储位置
            index = t.indexOf(c,index+1);
            //没找到
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    //双指针
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0,j = 0;
        while (i < m && j < n) {
            //匹配成功 i ++,j++
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            //匹配失败 i不动 j右移继续匹配
            j++;
        }  
        //如果i和s长度相等则返回true
         return i == m;
    }
}