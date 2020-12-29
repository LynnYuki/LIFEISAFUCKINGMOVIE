/**
* leetcode 234 回文链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //stack
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if(head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //递归倒序打印链表
    public void reversePrintListNode(ListNode head) {
        if (head != null) {
            return;
        }
        reversePrintListNode(head.next);
        System.out.pirntln(head.val);
    }
}