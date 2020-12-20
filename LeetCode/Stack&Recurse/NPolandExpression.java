/**
 * leetcode 150 逆波兰表达式求值
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int op1,op2;
        for(String str : tokens) {
            switch (str) {
                case"+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case"-":
                   op1 = stack.pop();
                   op2 = stack.pop();
                   stack.push(op2 - op1);
                   break;
                case"*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push (op1 * op2);
                    break;
                case"/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push (op2 / op1);
                    break;
                default:
                    stack.push(Integer.valueOf(str));
            }
        }
         return stack.pop();
    }
}