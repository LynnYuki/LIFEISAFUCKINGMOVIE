/**
 * leetcode 141 环形链表
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //哈希表存储ListNode去重
    public boolean hasCycle(ListNode head) {
       Set<ListNode> set = new HashSet<>();
        while (head != null) {
           if (!set.add(head)) {
               return true;
           }
            head = head.next;
        }
        return false;
    }
    
    //错位快慢指针
     public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        //快指针指向头节点的直接后继节点
        ListNode fast = head.next;
        //慢指针指向头结点
        ListNode slow = head;
        while (slow != fast) {
            //如果没环则fast会指向null
            if (fast == null || fast.next == null) {
                return false;
            }
            //移动一步
            slow = slow.next;
            //移动两步
            fast = fast.next.next;
        }
        return true;
    }
    //同一起始点快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    
}