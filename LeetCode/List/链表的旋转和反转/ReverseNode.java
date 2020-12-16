/**
 * leetcode 206 反转链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //迭代 头插法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            //指向当前节点的后一个节点
            temp = cur.next;
            //当前节点指向前驱节点
            cur.next = pre;
            //前进指针
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归
    // 假设链表是[1, 2, 3, 4, 5]从最底层最后一个reverseList(5)来看
    // 返回了5这个节点
    // reverseList(4)中
    // p为5
    // head.next.next = head 相当于 5 -> 4
    // 现在节点情况为 4 -> 5 -> 4
    // head.next = null,切断4 -> 5 这一条，现在只有 5 -> 4
    // 返回（return）p为5，5 -> 4
    // 返回上一层reverseList(3)
    // 处理完后返回的是4 -> 3
    // 依次向上
    public ListNode reverseList(ListNode head) {
		//递归终止条件是当前为空，或者下一个节点为空
		if(head == null || head.next == null) {
			return head;
		}
		//这里的cur就是最后一个节点
		ListNode cur = reverseList(head.next);
		//这里请配合动画演示理解
		//如果链表是 1->2->3->4->5，那么此时的cur就是5
		//而head是4，head的下一个是5，下下一个是空
		//所以head.next.next 就是5->4
		head.next.next = head;
		//防止链表循环，需要将head.next设置为空
		head.next = null;
		//每层递归函数都返回cur，也就是最后一个节点
		return cur;
	}


    //额外容器法
    public ListNode reverseList(ListNode head) {
        //将node节点值存入array
        ArrayList<Integer> array = getEle(head);
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        //倒序遍历array 顺序修改node的节点值
        for (int i = array.size() - 1; i >= 0; i--) {
            head.val = array.get(i); 
            head = head.next;
        }
        return sentinel.next;

    }
    public ArrayList getEle (ListNode l) {
        ArrayList<Integer> array = new ArrayList<>();
        while (l != null){
            array.add(l.val);
            l = l.next;
        }
        return array;
    }
}