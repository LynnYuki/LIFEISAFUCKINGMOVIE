/**
 * TX  20 有效的括号
 */

 class Solution {
     //辅助栈
    public boolean isValid(String s) {
        //奇数长度直接返回
        if (s.length() % 2 == 1) {
            return false;
        }
        //建立Hash映射表 注意映射key为右括号,value为左括号
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        //建立辅助栈
        LinkedList<Character> stack = new LinkedList<>();
        char [] arr = s.toCharArray();
         for(int i = 0; i<arr.length; i++){
             //如果数右括号
             if(map.containsKey(arr[i])){
                 //判断栈是否为空或栈顶元素是否和映射表中的值一样
                 if (stack.isEmpty() || stack.peek() != map.get(arr[i])) {
                     return false;
                 }
                 //出栈
                stack.pop();
             } else {
                 //入栈左括号
                  stack.push(arr[i]);
             }
         }
         return stack.isEmpty();
    }
}