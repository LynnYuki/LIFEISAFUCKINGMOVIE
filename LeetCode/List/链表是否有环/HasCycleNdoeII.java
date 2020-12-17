/**
 * leetcode 142 环形链表II
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
    //哈希表
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    //同起始点双指针 慢指针入环第一圈没走完的时候就会和快指针相遇
    // b为入环点到相遇点的弧长，c为相遇点到入环点的弧长 b + c为环的周长 a 为起点到入环点的长度
    // f = a + (b + c)n + b;
    // s = a + b;
    // f = 2s;
    // a = c + (n - 1)(b + c);
    //从相遇点到入环点的距离加上 n-1 圈的环长，恰好等于从链表头部到入环点的距离。
    //因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，
    //它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //相遇
            if (fast == slow) {
                //ptr指向头结点
                ListNode ptr = head;
                //ptr和slow在入环点相遇
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // fast 和 slow第一次相遇
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //fast充当ptr指针 指向头结点
        fast = head;
        //第二次相遇必在入环点
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}