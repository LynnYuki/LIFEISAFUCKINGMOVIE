/**
 * leetcode 14 获取字符串数组的最长公共前缀
 */
class Solution {
    //横向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //假定数组第一个字符串为最长公共前缀
        String prefix = strs[0];
        //遍历字符串数组逐一比较
        for (int i = 1; i < strs.length; i++) {
            prefix = getLongestPrefixt(prefix,strs[i]);
            //一旦公共前缀为空说明不存在 跳出
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;

    }
    //获取两个字符串的前缀 不断更新
    public String getLongestPrefixt(String str1,String str2) {
        int len = Math.min(str1.length(),str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0,index);
    }
    //纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //假定第一个元素为最长公共前缀字符串
        String prefix = strs[0];
        //横向扫描第一个字符串
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            //横向扫描str,从第二个元素开始,纵向比较str[j].charAt(i)字符和第一个元素字符是否相等
            for (int j = 1; j < strs.length; j++) {
                //如果i等于后面位置j的元素说明已经到该元素的末尾,不能继续扫描则返回前缀
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                     prefix = prefix.substring(0,i);
                }
            }
        }
        return prefix;
    }
}