/**
 * 剑指Offer 05 替换空格
 */

class Solution {
    public String replaceSpace(String s) {
        StringBuilder sbf = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
           if(s.charAt(i) == 32){
               sbf.append("%20");
           }else{
               sbf.append(s.charAt(i));
           }
                
        }
        return sbf.toString();
    }
}