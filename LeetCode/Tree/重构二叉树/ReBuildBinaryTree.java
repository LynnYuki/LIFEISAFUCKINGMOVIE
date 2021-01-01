/**
 * leetcode 105
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode myBuildTree(int[] preorder,int pLeft,int pRight,int[] inorder,int iLeft,int iRight) {
        if (pLeft > pRight) {
            return null;
        }
        //根节点为preorder的第一个值
        int rootVal = preorder[pLeft];
        //构造根节点
        TreeNode root = new TreeNode(rootVal);
        //获取根节点在inorder的下标
        int pIndex = map.get(rootVal);
        //递归构造左子树 计算左子树在preorder中的区间值 左子树的结点个数在preorder和inorder中是一样的
        //假设左子树在preorder中的右边界为x 则有等式 x-pLeft-1 = pIndex-1 - iLeft  则x = pIndex - pLeft - iLeft;
        //递归左子树时分别传入左子树在preorder和inorder中的区间值
        root.left = myBuildTree(preorder,pLeft+1,pIndex+pLeft-iLeft,inorder,iLeft,pIndex-1);
        //递归构造右子树  计算右子树在preorder中的区间值       
        //递归右子树时分别传入左子树在preorder和inorder中的区间值
        root.right = myBuildTree(preorder,pIndex+pLeft-iLeft+1,pRight,inorder,pIndex+1,iRight);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //存储根节点在中序遍历列表中的Index
        for (int i = 0 ; i < n; i++) {
            map.put(inorder[i],i);
         }
         //传入的参数为前序遍历数组,前序遍历的子树区间,中序遍历,中序遍历的子树区间
        return myBuildTree(preorder,0,n - 1,inorder,0,n - 1);
    }
}