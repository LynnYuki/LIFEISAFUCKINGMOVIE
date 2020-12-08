/**
 * leetcode 6 Z字形变换
 */
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = Math.min(s.length(),numRows);
        String[] rows = new String[len];
        for (int i = 0; i < len; i++) {
            rows[i] = "";
        }
        //游标记录 当前行的索引
        int cur = 0;
        //遍历的方向 false 向上 true 向下
        boolean direction = false;
        for (int j = 0; j < s.length(); j++) {
            rows[cur] += s.charAt(j);
            //游标指向第一行或者最后一行转向遍历
            if (cur == 0 || cur == len - 1) {
                direction = !direction;        
            }
            if (direction) {
                cur++;
            } else { 
                cur--;
            }
        }
        StringBuilder stb = new StringBuilder();
        for (String sub : rows) {
            stb.append(sub);
        }
        return stb.toString();
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            list.add(new StringBuilder());
        }
        int cur = 0;
        int increment = -1;
        for (char sub : s.toCharArray()) {
            list.get(cur).append(sub);
            if (cur == 0 || cur == numRows -1) {
                increment = - increment;
            }
            cur += increment;
        }
        StringBuilder stb = new StringBuilder();
        for (StringBuilder stb2 : list) {
            stb.append(stb2);
        }
        return stb.toString();
    }
}