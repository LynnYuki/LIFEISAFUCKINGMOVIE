/**
 * 剑指offer 58-I 翻转单词顺序
 */

class Solution {
    //从右向左的双指针
    public String reverseWords(String s) {
        //去除首尾空格
        s = s.trim();
        int i = s.length() - 1;
        int j = s.length() - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            //从右向左搜索单词的第一个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            //搜索到的第一个空格之后的单词放入结果集
             res.append(s.substring(i+1,j+1) + ' ');
             //如果出现连续的空格则跳过
             while (i >= 0 && s.charAt(i) == ' ') {
                 i--;
             }
             //跳过多个空格之后第一个不是空格的字符右指针左移到下个单词尾字符继续循环
             j=i;
        }
        return res.toString().trim();
    }
}