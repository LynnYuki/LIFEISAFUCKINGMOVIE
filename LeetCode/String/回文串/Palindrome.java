/**
 * leetcode 125 验证回文串
 */
 class Solution {
    public boolean isPalindrome(String s) {
        if ( s == null || s.length() == 0) {
            return true;
        }
        List<String> list = new ArrayList<>();
        StringBuilder stb = new StringBuilder();
        boolean isPalinDrome = true;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if ( temp >= 'a' && temp <= 'z' || temp >='0' && temp <= '9' || temp >= 'A' && temp <= 'Z') {
               list.add(String.valueOf(temp));
            }  
            // if (Character.isLetterOrDigit(temp)) {
            //     stb.append(Character.toLowerCase(temp));
            // } 
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            // if (Character.toLowerCase(stb.charAt(left)) != Character.toLowerCase(stb.charAt(right)) ){
            //     isPalinDrome = false;
            // }
            if (!list.get(left).equalsIgnoreCase(list.get(right))){
                isPalinDrome = false;
            }
            left ++ ;
            right --;
        }
      return isPalinDrome;
    }
    
    //空间优化为O(1) 双指针原字符串操作
     public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean isPalinDrome = true;
        while (left < right) {
            //跳过非数字或字母元素
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++ ;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    isPalinDrome = false;
                }
                left++;
                right--;
            }
        }
       

      return isPalinDrome;
    }
}