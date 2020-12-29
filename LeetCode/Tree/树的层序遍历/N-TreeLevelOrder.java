/*
* leetcode 429 N叉树的层序遍历
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
    //迭代
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int cur = queue.size();
            for (int i = 0; i < cur; i++) {
                Node node = queue.poll();
                list.add(node.val);
                //将每层的子节点树入队
                // for (int j = 0; j < node.children.size();j++) {
                //     queue.add(node.children.get(j));
                // }
                queue.addAll(node.children);
            }
            res.add(list);
        }
        return res;
    }
}