/**
 * leetcode 522. 最长特殊序列 II
 */

class Solution {
    //如果存在这样的特殊序列，那么它一定是某个给定的字符串。
    //检查每个字符串是否是其他字符串的子序列。如果不是，则它是一个特殊序列。最后返回长度最大的特殊序列。如果不存在特殊序列，返回 -1。
    public int findLUSlength(String[] strs) {
      int res = -1;
      //遍历strs
      for (int i = 0,j; i < strs.length; i++) {
          for ( j = 0; j < strs.length; j++) {
              //自身不比较
              if (i == j) {
                  continue;
              }
              //比较索引i的字符串是否是索引j的子序列
              if(isSubSequence(strs[i],strs[j])) {
                  break;
              }
            } 
            //一轮遍历完保存长度值
            if (j == strs.length) {
                res = Math.max(res,strs[i].length());
            }
      }
      return res;

    }
    //判断是否子序列
    public boolean isSubSequence (String pat,String txt) {
        int j = 0;
        for (int i = 0; i < txt.length() && j < pat.length();i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            }
        }
        return j == pat.length();
    }
}