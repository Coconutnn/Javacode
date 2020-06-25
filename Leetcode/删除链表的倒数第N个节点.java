/*19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode pre = new ListNode(1);
        ListNode h1 = head;
        ListNode h2 = head;
        pre.next = head;
        for(int i=0;i<n;i++){
            h1 = h1.next;
        }
        while(h1!=null){
            h1=h1.next;
            h2=h2.next;
            pre = pre.next;
        }
        pre.next = h2.next;
        h2.next =null;
        if(head==h2){
            return pre.next;
        }
        return head;
    }
}

