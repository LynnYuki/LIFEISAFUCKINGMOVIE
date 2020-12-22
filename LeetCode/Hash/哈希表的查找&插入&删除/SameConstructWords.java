/**
 * leetcode 205 同构字符串
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //调用两次
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);

    }
    //判断每个字符的映射关系
    public boolean isIsomorphicHelper (String s,String t) {
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            //如果包含此key
            if (map.containsKey(ch1)) {
                //获取此key的value 与当前遍历到的字符比较
                if (map.get(ch1) != ch2) {
                    return false;
                }
                //不存在key则添加映射关系
            } else {
                map.put(ch1,ch2);
            }
        }
        return true;
    }
}