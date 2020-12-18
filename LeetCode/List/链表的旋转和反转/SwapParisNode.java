/**
 * leetcode 24 两两交换链表节点
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //迭代  0 -> 1 -> 2 -> 3 -> 4 -> 5
   //     s,c   n1   n2
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = sentinel;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1; 
            //注意，反转后n1变为当前反转的部分的尾部，cur应该移动到n1位置
            cur = node1;
         }
         return sentinel.next;
    }
}