/**
 * leetcode 17 电话号码的字母
 */
 class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character,String> phoneMap = new HashMap<>() {{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        backTrack(res,phoneMap,digits,0,new StringBuilder());
        return res;
    }
    public void backTrack(List<String> res,Map<Character,String> phoneMap,String digits,int index,StringBuilder stb) {
        //回溯的条件
        if (index == digits.length()) {
            res.add(stb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                stb.append(letters.charAt(i));
                //递归调用
                backTrack(res,phoneMap,digits,index + 1,stb);
                //删除已经组合过的letters 保持前缀不变
                stb.deleteCharAt(index);
            }
        }

    }

    //队列操作
    public List<String> letterCombinations(String digits) {
        List <String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<Character,String> phoneMap = new HashMap<>() {{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String temp = phoneMap.get(digits.charAt(i));
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            int size = res.size();
            for (int m = 0; m < size;m++) {
                //每次都从队列中拿出第一个元素
                  String temp2 = res.remove(0);
                for (int j = 0; j < temp.length(); j++) {
                    //然后跟"def"这样的字符串拼接，并再次放到队列中
                    res.add(temp2 + temp.charAt(j));
                 }
             } 
        }
        return res;
    }
}