/**
 * leetcode 383 赎金信
 */
 class Solution {
     //哈希表
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if(magazine == null || magazine.length() == 0) {
            return false;
        }
        //用两个哈希表分别统计字符出现次数
        Map<Character,Integer> mapm = new HashMap<>();
        Map<Character,Integer> mapr = new HashMap<>();
        boolean isSuccess = false;
        for (char ch : magazine.toCharArray()) {
            mapm.put(ch,mapm.getOrDefault(ch,0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            mapr.put(ch,mapr.getOrDefault(ch,0) + 1);
        }
        //遍历ransom map 如果其中的元素在 magazine map中出现的次数 大于或等于 其在ransom map中的出现次数则为true
        for (Map.Entry<Character,Integer> entry : mapr.entrySet()) {
            if(mapm.containsKey(entry.getKey()) && mapm.get(entry.getKey()) >= entry.getValue()) {
                isSuccess = true;
            } else {
                //出现不符合的直接中断返回
                 isSuccess = false;
                 break;
            }
           
        }
        return isSuccess;
    }
}