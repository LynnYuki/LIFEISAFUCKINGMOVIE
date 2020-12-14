/**
 * TX 7 整数反转
 */
class Solution {
    public int reverse(int x) {
        int tempx = Math.abs(x);
        String s = String.valueOf(tempx);
        char[] c = s.toCharArray();
        int left = 0,right = s.length() -1;
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] =temp;
            left++;
            right--;
        }
        int res = 0;
        try {
            res = Integer.valueOf(String.valueOf(c));
            if(x < 0) {
            res *= -1;
            }
        } catch(Exception e){
            return 0;
        }
        return res;
    }
}