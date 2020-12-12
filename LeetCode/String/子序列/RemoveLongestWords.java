/**
 * leetcode 524 通过删除字母匹配到字典里最长单词
 */

class Solution {
   // 若i,j对应的两个字符相等，则j后移，如果j可以移到str.length()，那么说明str中对应的字符s中都有，即s中删除一些字符后，可以得到str字符串
    public String findLongestWord(String s, List<String> d) {
         String longesStr = "";
         //遍历List中的字符串元素
         for (String str : d) {
             int i = 0,j = 0;
             while (i < s.length() && j < str.length()) {
                 //如果List中的字符元素依次和s的char依次比较
                 if (s.charAt(i) == str.charAt(j)) {
                     j++;
                 }
                 //List的子元素已经遍历完
                 if (j == str.length()) {
                     //compareTo比较字典序
                     if (str.length() > longesStr.length() || (str.length() == longesStr.length() && longesStr.compareTo(str) > 0) ) {
                         longesStr = str;
                     }
                 }
                 i++;
             }
         }
         return longesStr;
    }
}