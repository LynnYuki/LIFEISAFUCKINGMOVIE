/**
 * leetcode 145 二叉树的后序遍历
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        res.add(node.val);
        return res;
    }
    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        //标记已经加入res的右子树节点
        TreeNode seen = null;
        while (!stack.isEmpty() || root != null) {
            //迭代访问左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //遇到左子树节点为null则弹出当前子树的root继续判断右子树
            root = stack.pop();
            if (root.right == null || root.right == seen) {
                res.add(root.val);
                seen = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}