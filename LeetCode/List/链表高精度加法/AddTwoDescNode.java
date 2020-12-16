/**
 * leetcode 2 两数相加
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
    //BigInteger
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //转换为BigInteger计算
        java.math.BigInteger a = new java.math.BigInteger(getEle(l1).reverse().toString());
        java.math.BigInteger b = new java.math.BigInteger(getEle(l2).reverse().toString());
        java.math.BigInteger c = a.add(b);
        String sums = c.toString() ;
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        //倒序遍历String 打印链表
        for (int i = sums.length() - 1; i >= 0; i--) {
            ListNode ele = new ListNode(sums.charAt(i) - '0');
            prev.next = ele;
            prev = prev.next;
        }
        return sentinel.next;
        
    }
    
    //获取每个链表中的val转换为StringBuilder
    public StringBuilder getEle (ListNode l1) {
        StringBuilder stb = new StringBuilder();
        while (l1 != null) {
            stb.append(l1.val);
            l1 = l1.next;
        }
        return stb;
    }

    //直接相加法
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        //进位值
        int carry = 0;
        while (l1 != null || l2 != null) {
            //短的链表则补0
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            //获取新的进位值
            carry = sum / 10;
            //每个链表中存储的只是余数
            sum = sum % 10;
            prev.next = new ListNode(sum);
            prev = prev.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            } 
            //如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
            if(carry == 1) {
                prev.next = new ListNode(carry);
            } 
        }
        return sentinel.next;
    }
}