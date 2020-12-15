/**
 * leetcode 19 删除倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);
        //初始化哨兵节点 指向head
        ListNode sentinel = new ListNode(0,head);
        //当前节点指向哨兵节点
        ListNode cur = sentinel;
        //倒数第n个节点即为正数第length - n + 1个节点 下标从1开始 cur指针指向需要删除节点的前一个节点
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        //将删除节点之前的节点指向删除节点之后的节点
        cur.next = cur.next.next;
        //返回头sentinel.next 不直接返回head是因为可能被删除
        ListNode res = sentinel.next;
        return res;
        
    }
    //获取链表长度
    public int getLength (ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    //双指针法 key 先移动start指针 n次 当start 和end 间隔为n时同时移动两个指针 直到start.next == null 终止
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0,head);
        ListNode start = sentinel;
        ListNode end = sentinel;

        while (n != 0) {
            start = start.next;
            n--;
        } 
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return sentinel.next;
        
    }
}