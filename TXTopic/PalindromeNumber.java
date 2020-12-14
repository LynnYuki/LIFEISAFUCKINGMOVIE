/**
 * TX 9 回文数
 */
class Solution {
    //字符串转换
    public boolean isPalindrome(int x) {
        if (x < 0 ||  (x >= 10 && x % 10 == 0) ) {
            return false;
        }
        String s = String.valueOf(x);
        if(s.length() < 2){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean isPalindrome = true;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                return isPalindrome;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }

    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

      //反转一半数字
    public boolean isPalindrome(int x) {
        //排除负数和末尾为0的整数
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNum = 0;

        while (x > reverseNum) {
            //依次取出末尾的数
            int remainder = x % 10;
            //组合倒序的数
            reverseNum = reverseNum*10 + remainder;
            //去除末尾的数
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == reverseNum || x == reverseNum / 10;
    }
}