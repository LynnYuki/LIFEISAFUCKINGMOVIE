/*
* leetcode 559 N-叉树的最大深度
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
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 1;
        for (Node node : root.children) {
            depth = Math.max(depth,1+maxDepth(node));
        }
        return depth;
    }

    //BFS计数
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cursize = queue.size();
            for (int i = 0; i < cursize; i++) {
                Node node = queue.poll();
                queue.addAll(node.children);
            }
            depth++;
        }
        return depth;
    }
}