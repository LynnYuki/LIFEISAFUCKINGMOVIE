/**
 * leetcode 889 前序后序遍历生成二叉树
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  //解法类似之前中+中后遍历生成二叉树
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        //存储post的每个值和对应的下标
        for (int i = 0; i < post.length;i++) {
            map.put(post[i],i);
        }
        return myBuildTreeNode(pre,0,n - 1,post,0,n - 1);
    }

    public TreeNode myBuildTreeNode (int[] pre,int preStart,int preEnd,int[] post,int poStart,int poEnd) {
        if (preStart > preEnd || poStart > poEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        //防止越界
        if (preStart == preEnd) {
            return root;
        }
        //获取左子树的根节点并计算左右子树的区间           
        int index = map.get(pre[preStart + 1]);
        //可以去除map 优化空间
        // int index = 0;
        // 在post中寻找左子树根节点的index值
        //  while(post[index]!=pre[preStart+1]){
        //     index++;
        // }
        root.left = myBuildTreeNode(pre,preStart + 1,index - poStart + preStart + 1,post,poStart,index);
        root.right = myBuildTreeNode(pre,index - poStart + preStart + 2,preEnd,post,index + 1,poEnd - 1);
        return root;
    }
}