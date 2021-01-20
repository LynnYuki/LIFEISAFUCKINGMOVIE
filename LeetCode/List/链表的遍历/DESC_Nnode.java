/**
 * 剑指offer 22 链表中的倒数第k个节点
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {   
        ListNode fast = head;
        ListNode slow = head;
        //先让fast走k步
        for(int i = 0; i < k; i++) {
            if(fast == null) {
                return null;
            }
            fast = fast.next;
        }
        //然后fast、slow同时走，当fast指向null时，slow指向的即为倒数第K个节点
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}