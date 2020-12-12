/**
 * leetcode 389 找不同
 */
class Solution {
    //作差法
    public char findTheDifference(String s, String t) {
        int sum1 = getCharSums(s);
        int sum2 = getCharSums(t);
        return (char)(sum2 - sum1);
             
    }
    public int getCharSums (String txt) {
        int sum = 0;
        for (char ch : txt.toCharArray()) {
            sum +=ch;
        }
        return sum;
    }

    //哈希表法
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            maps.put(ch,maps.getOrDefault(ch,0) + 1);
        }
        for (char ch : t.toCharArray()) {
            mapt.put(ch,mapt.getOrDefault(ch,0) + 1);
        }
        //判断每个出现的字符次数是否一样 如果在maps里没出现则为添加的字符
        for (char i = 'a'; i <= 'z';i++) {
            if (maps.get(i) != mapt.get(i)) {
                return i;
            }
        }
        return ' ';
    }
}