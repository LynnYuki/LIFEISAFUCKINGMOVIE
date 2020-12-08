/**
 * leetcode 482 秘钥格式化
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        //S = S.replace("-","");
        StringBuilder stb = new StringBuilder();
        //去除‘-’
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') {
                stb.append(S.charAt(i));
            }
        }
        int len = stb.length();
        //余数
        int remainder = len % K;
        //商
        int n = len / K;
        StringBuilder res = new StringBuilder();
        //能被整除
        if (remainder == 0) {
            //i是从1 开始 n表示需要截取的次数
            for (int i = 1; i <= n; i++) {
                //不是最后一项加‘-’
                if (i != n) {
                    //截取区间为[0,K),[K,2K)... [(i-1)*K,i*K)
                    res.append(stb.substring((i-1)*K,i*K) + '-');
                } else {
                    res.append(stb.substring((i-1)*K,i*K));
                }
            }
        //不能被整除 则需要截取n+1次
        } else if (remainder != 0) {
            //考虑K大于过滤之后的长度则截取时不需要加‘-’
            if (len <= K) {
                 res.append(stb.substring(0,remainder));
            } else {
                 res.append(stb.substring(0,remainder) + '-');
            }
            //注意i是从2开始
            for (int i = 2; i <= n + 1; i++ ) {
                if (i != n + 1) {
                    res.append(stb.substring(remainder+(i-2)*K,remainder+(i-1)*K) + '-');
                } else {
                    res.append(stb.substring(remainder+(i-2)*K,remainder+(i-1)*K));
                }
            }
        }
        return res.toString();
    }
    
    //逆序添加 count计数
     public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        StringBuilder stb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                stb.insert(0,S.charAt(i));
                count ++ ;
                 if (count % K == 0) {
                    stb.insert(0,"-");
                }
            }
        } 
        if (stb.length() > 0 && stb.charAt(0) == '-') {
            stb.delete(0,1);
        }
        return stb.toString();
    }
}