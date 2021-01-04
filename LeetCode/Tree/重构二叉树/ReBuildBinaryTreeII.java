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

    //寻找链表的中位数结点
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildTree (head,null);
    }
    public TreeNode buildTree (ListNode head,ListNode tail) {
        if (head == tail ) {
            return null;
        }
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //fast走两步,slow走一步,fast到达tail时slow刚好在中间
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head,slow);
        root.right = buildTree(slow.next,tail);
        return root;
    }
}