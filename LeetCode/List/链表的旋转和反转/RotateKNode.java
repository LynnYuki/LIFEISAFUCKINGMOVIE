/**
 * leetcode 61 旋转链表
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
    //遍历+迭代 链表每个节点向右移动 k 个位置
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        //链表长度
        int len = 0;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = head;
        ListNode prev = sentinel;
        //标记尾节点
        ListNode tail = null;
        while (head != null) {
            len++;
            //tail指向尾节点
            if(head.next == null) {
                tail = head;
            }
            head = head.next;
            
        }
        //计算偏移量
        int offset =  k % len;
        //如果偏移步数为链表长度直接返回原链表
        if (offset == 0) {
            return sentinel.next;
        } else {
            //计算cur指针移动的步数
            int move = len - offset;
            //移动cur指针和prev指针
            while (move > 0) {
                cur = cur.next;
                prev = prev.next;
                move--;
            }
            //标记头部节点
            ListNode temp = sentinel.next;
            //需要移动的cur指针的节点指向变为新的链表的尾部节点指向null
            prev.next = null;
            //头部节点指向cur
            sentinel.next = cur;
            //尾部节点指向标记的头部节点
            tail.next = temp;
        }
        return sentinel.next;
    }
}