/**
 * leetcode 682棒球比赛
 */
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0,top = 0,temp = 0;
        for (int i = 0; i < ops.length; i++){
            switch (ops[i]) {
                case "+":
                    top = stack.pop();
                    temp = top + stack.peek();
                    stack.push(top);
                    sum += stack.push(temp);
                    break;
                case"D":
                    sum += stack.push(2*stack.peek());
                    break;
                case"C":
                    sum -= stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
                    sum += Integer.parseInt(ops[i]);
            }
        }
        return sum;
    }
}