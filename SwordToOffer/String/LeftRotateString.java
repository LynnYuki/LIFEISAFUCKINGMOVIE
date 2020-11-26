/**
 * 剑指Offer 58 左旋字符串
 */
class Solution {
    //切片函数
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder( s.substring(n,s.length()));
        sb.append(s.substring(0,n));
        return sb.toString();
        
        //return s.substring(n)+s.substring(0,n);
    }

    //非切片函数
    public String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n;i<n+s.length();i++){
            //取余骚操作简化第二次循环
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

 

}