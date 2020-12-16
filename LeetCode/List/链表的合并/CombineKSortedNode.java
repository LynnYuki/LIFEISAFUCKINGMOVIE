/**
 * leetcode 23 合并K个升序排列链表
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
    //顺序合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res,lists[i]);
        }
        return res;
    }

    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists (l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    //分治法
     public ListNode mergeKLists(ListNode[] lists) {
        return merge (lists,0,lists.length - 1);
    }
    public ListNode merge (ListNode[] list,int start,int end) {
        if (start == end) {
            return list[start];
        }
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        //递归
        return mergeTwoLists(merge(list,start,mid),merge(list,mid + 1 ,end));
    }
    //迭代
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 :l1;
        return sentinel.next;
    }

    //优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        //升序排列的优先队列
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>((x,y)-> x.val - y.val);
        //将所有链表的头结点加入优先队列
        for(ListNode node : lists) {
            if (node != null) {
                pQueue.offer(node);
            }
        }

        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;

        while (!pQueue.isEmpty()) {
            //取出当前队列中最小的链表头节点
            prev.next = pQueue.poll();
            prev = prev.next;
            if (prev.next != null) {
                //将该最小头结点链表的其他元素加入优先队列
                pQueue.offer(prev.next);
            }
        }
        return sentinel.next;
    }
}