/**
 * leetcode 700 二叉搜索树的搜索
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //递归
    //二叉搜索树是一棵二叉树，每个节点都有以下特性：
    // 大于左子树上任意一个节点的值，
    // 小于右子树上任意一个节点的值。
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left,val) : searchBST(root.right,val);
    }
    //迭代
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}