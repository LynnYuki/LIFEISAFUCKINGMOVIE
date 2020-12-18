/**
 * leetcode 25 K个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            //初始化tail节点 
            ListNode tail = pre;
            //依次寻找翻转转的K组链表元素的尾部节点
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                //如果已经到末尾或者元素不够k个则直接返回不再继续翻转
                if (tail == null) {
                    return hair.next;
                }
            }
            //指向tail的下一节点值
            ListNode nex = tail.next;
            //返回翻转的k个链表元素的新头尾节点
            ListNode reverse[] = revserseNode(head,tail);
            //head指向新的翻转后头节点
            head = reverse[0];
            //tail指向新的翻转后尾节点
            tail = reverse[1];
            //链接翻转后的头尾节点
            pre.next = head;
            tail.next = nex;
            //移动pre head指针进行下一轮翻转
            pre = tail;
            head = nex;
        }
         return hair.next;
    }
    
    //头插法翻转
    public ListNode[] revserseNode (ListNode head,ListNode tail) {
        //尾节点指向null否则无法终止while循环
        tail.next = null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //翻转后头尾倒置
        return new ListNode[] {tail,head};
    }
}