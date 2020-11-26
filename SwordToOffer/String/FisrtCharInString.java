/**
 * 剑指offer50 第一个只出现一次的字符
 */
class Solution {
  //有序哈希表
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i< s.length();i++) {
            char ch = s.charAt(i);
            map.put(ch ,map.getOrDefault(ch ,0)+1);
        }
    
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            char letter = entry.getKey();
            int count = entry.getValue();
            if (count == 1) {
                return letter;
            }
        }
        return ' ';
    }

    //使用数组
    public char firstUniqChar(String s) {
        int [] count = new int [256];
        for (char c : s.toCharArray()) {
          //统计字母出现的次数
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            if (count[c] == 1) {
                return c;
            }
        }
        return ' ';
    }
}