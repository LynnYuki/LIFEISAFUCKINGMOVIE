/**
 * leetcode 520 检测大写字符
 */
 class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        int firstChar = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                if( i == 0 && (word.charAt(i) >= 65 && word.charAt(i) <= 90)){
                    firstChar++;
                }
                count ++;
            }
        }   
        if (count == word.length() || count == 0 || (count == 1 && firstChar == 1)) {
            return true;
        } 
            return false;
    }
}