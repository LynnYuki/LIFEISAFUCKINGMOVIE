/**
 * leetcode 445 两数相加II
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        java.math.BigInteger a = new java.math.BigInteger(getEle(l1).toString());
        java.math.BigInteger b = new java.math.BigInteger(getEle(l2).toString());
        java.math.BigInteger c = a.add(b);
        String sums = c.toString();
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        for (int i = 0; i < sums.length(); i++) {
            prev.next = new ListNode(sums.charAt(i) - '0');
            prev = prev.next;
        }
        return sentinel.next;
    }

    public StringBuilder getEle (ListNode l1) {
        StringBuilder stb = new StringBuilder();
        while (l1 != null) {
            stb.append(l1.val);
            l1 = l1.next;
        }
        return stb;

    }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stackl1 = putToStack(l1);
        LinkedList<Integer> stackl2 = putToStack(l2);
        int carry = 0;
        //头插法
        ListNode head = null;
        //出栈逆序相加
        while (!stackl1.isEmpty()  || !stackl2.isEmpty() || carry != 0) {
            int a = stackl1.isEmpty() ? 0 : stackl1.pop();
            int b = stackl2.isEmpty() ? 0 : stackl2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            sum  %= 10;
            ListNode cur = new ListNode(sum);
            cur.next = head;
            head = cur;
            
        }
        return head;
    }
    
    //链表入栈
    public LinkedList putToStack (ListNode l) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }