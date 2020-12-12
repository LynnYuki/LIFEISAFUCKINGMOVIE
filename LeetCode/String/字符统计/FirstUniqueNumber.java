/**
 * leetocde 387. 字符串中的第一个唯一字符
 */
 class Solution {
     //逐一比较每个字符和其他字符是否相同,返回第一个遍历到字符串末尾的字符的下标i
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        for (int i = 0 ,j; i < s.length(); i++) {
            for(j = 0; j < s.length();j++) {
                if(i == j) {
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)) {
                    break;
                }
            }
            if (j == s.length()) {
                return i;
            }
        }
        return -1;
    }

    //Map 存储每个字符的出现的次数 返回第一个出现次数为1的字符,然后返回其在s的下标
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
         }
         Map<Character,Integer> map = new LinkedHashMap<>();
         for (char ch : s.toCharArray() ) {
             map.put(ch,map.getOrDefault(ch,0) + 1);
         }
         for(Map.Entry<Character,Integer> entry : map.entrySet()) {
             if(entry.getValue() == 1) {
                 return s.indexOf(entry.getKey());
             }
         }
         return -1;
    }
}