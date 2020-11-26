/**
 * 剑指Offer 15 数组中重复的数字
 */

 public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for(int i =0;i<binary.length();i++) {
            if(binary.charAt(i)== '1') {
                count++;
            }
        }
        return count;
    }
    // n&1 可判断二进制最右边是否为1
    public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0) {
            count += n&1;
            n >>>=1;

         }
       }
        return count;
   }
 
    // n&(n-1)可消去二进制最右边的1
   public int hammingWeight2(int n) {
        int count = 0;
        while(n!=0) {
            count++;
           n &= n-1;

         }
       }
        return count;
   }
    

 }