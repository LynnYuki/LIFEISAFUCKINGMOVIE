/**
 * leetcode 500 键盘行
 */
class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character,Integer> map=getMap();
        String[] res=new String[words.length];
        //记录返回数组长度
        int index=0;
        for (String word:words) {
            int tmp=0;
            int len=word.length();
            for (int i=0;i<len;i++) {
                char c=word.charAt(i);
                if(c>=97){
                    //小写字母转大写
                    c=(char)(c-32);
                }
                //记录行号
                int line=map.get(c);
                //如果同一单词中的行号不相同则直接跳出
                if (tmp != 0 && line != tmp){ 
                    break;
                }
                tmp = line;
                if (i == len-1) {
                    //存放返回结果
                    res[index++] = word;
                } 
            }
        }
        return Arrays.copyOf(res,index);
    }
    //记录字母行号
    public HashMap getMap(){
        HashMap<Character,Integer> map=new HashMap();
        //第一行
        map.put('Q',1);
        map.put('W',1);
        map.put('E',1);
        map.put('R',1);
        map.put('T',1);
        map.put('Y',1);
        map.put('U',1);
        map.put('I',1);
        map.put('O',1);
        map.put('P',1);
        //第二行
        map.put('A',2);
        map.put('S',2);
        map.put('D',2);
        map.put('F',2);
        map.put('G',2);
        map.put('H',2);
        map.put('J',2);
        map.put('K',2);
        map.put('L',2);
        //第三行
        map.put('Z',3);
        map.put('X',3);
        map.put('C',3);
        map.put('V',3);
        map.put('B',3);
        map.put('N',3);
        map.put('M',3);
        return map;
  
    }
}