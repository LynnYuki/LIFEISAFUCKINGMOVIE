/**
 * leetcode 106 根据中序后续遍历重构二叉树
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  //解法类似105
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n;i++ ) {
            map.put(inorder[i],i);
         }
         return myBuildTree(inorder,0,n - 1,postorder,0,n - 1);
    }
    public TreeNode myBuildTree(int[] inorder,int iLeft,int iRight,int[] postorder,int pLeft,int pRight) {
        if (iLeft > iRight) {
            return null;
        }
        int rootVal = postorder[pRight];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = myBuildTree(inorder,iLeft,pIndex - 1,postorder,pLeft,pRight - iRight + pIndex - 1);
        root.right = myBuildTree(inorder,pIndex + 1,iRight,postorder,pRight - iRight + pIndex,pRight - 1);
        return root;
     }
}