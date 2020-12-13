/**
 * leetcode 242 有效的字母异位词
 */
class Solution {
  //排序
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.toString(b).equals(Arrays.toString(a));
    }
  // 哈希表统计字符出现的次数
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length()) {
            return false;
        }
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();

        for (char ch : s.toCharArray()) {
            maps.put(ch,maps.getOrDefault(ch,0) + 1);
        }
        for (char ch : t.toCharArray()) {
            mapt.put(ch,mapt.getOrDefault(ch,0) + 1);
        }
        for (Map.Entry<Character,Integer> entry : maps.entrySet()) {
            if (!maps.get(entry.getKey()).equals(mapt.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}