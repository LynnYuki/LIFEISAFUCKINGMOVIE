

/**
 * leetcode 203 移除链表元素
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //初始化哨兵节点
        ListNode sentinel = new ListNode(0);
        //哨兵节点指向头部节点
        sentinel.next = head;
        //初始化前驱节点和当前节点指针分别指向哨兵节点和头节点
        ListNode prev = sentinel;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                //前驱节点指向当前节点的下一个节点
                prev.next = cur.next;
            } else {
                //前驱节点后移
                prev = cur;
            } 
            //当前节点后移
            cur = cur.next;
        }
        return sentinel.next;
    }
}