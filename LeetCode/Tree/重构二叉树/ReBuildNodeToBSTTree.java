/**
 * leetcode 109 将有序链表转换为二叉搜索树
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
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
    //将链表转换为nums 解法同108
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] nums = new int[list.size()];
        // 一行代码转换List<Integer>为int[]
        // int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < list.size();i++) {
            nums[i] = list.get(i);
        }
        Arrays.sort(nums);
        return helper(nums,0,nums.length - 1);
    }
    public TreeNode helper (int [] nums,int left,int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid - 1);
        root.right = helper(nums,mid + 1,right);
        return root;
    }
}