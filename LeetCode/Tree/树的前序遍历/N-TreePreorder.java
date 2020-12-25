/*
 * leetcode 589 N叉树的前序遍历
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
    public List<Integer> preorder(Node root) { 
            if (root == null) {
                return res;
            }
            res.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }
            return res;
    }

    //前序遍历迭代法
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        //存放children的栈
        Deque<Node> stack = new ArrayDeque<>();
        if (root == null) {
            return res;
        } else {
            stack.push(root);
        }
        //栈不为空一直迭代
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            //从右向左入栈子节点 出栈则为从左向右遍历
            for (int i = node.children.size() - 1; i >= 0; i--) { 
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}