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

    //递归
    //其中我们应该关心的主要有三点：

    // 返回值
    // 调用单元做了什么
    // 终止条件
    // 在本题中：
    // 返回值：交换完成的子链表
    // 调用单元：设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
    // 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //next 为头结点的直接后继节点
        ListNode next = head.next;
        //head连接已经完成交换的子链表
        head.next = swapPairs(next.next);
        //next指向head
        next.next = head;
        return next;
    }
}