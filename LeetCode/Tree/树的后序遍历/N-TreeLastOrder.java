/*
 * leetcode 590 N叉树的后序遍历
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);
        return res;
    }
    
    //迭代 伪后序遍历 反转并不是真正按照内存后序遍历输出的
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            //顺序添加子节点
            for (int i = 0; i < node.children.size(); i++) {
               stack.push(node.children.get(i));
            }
        }
        //翻转结果即为后序遍历
        Collections.reverse(res);
        return res;
    }
    //迭代 真后序遍历 不反转
    public List<Integer> postorder(Node root) {
        //双端队列
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            //队列尾出队和出栈一样
            Node node  = stack.pollLast();
            //队列头插法
            res.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return res;
    }
}