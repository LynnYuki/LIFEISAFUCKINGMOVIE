/**
 * leetcode 92 反转链表II 1<=m<=n<node.length
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //迭代头插法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode posPrev = sentinel;
        ListNode cur = sentinel.next;

        int index = 1;
        //找到开始截取的起始位置
        while (index < m) {
            posPrev = posPrev.next;
            cur = cur.next;
            index++;
        }
        //此时posPrev指向开始反转节点的前一个位置，cur指向开始反转的节点
        for (int i = 1; i < n - m + 1; i++) {
            //临时变量存放cur后面直接后继节点
            ListNode remove = cur.next;
            //当前节点指向直接后继节点的下一节点
            cur.next = cur.next.next;
            //直接后继节点指向posPrev.next即为cur节点
            remove.next =posPrev.next;
            posPrev.next = remove; 
        }
        return sentinel.next;
    }
}