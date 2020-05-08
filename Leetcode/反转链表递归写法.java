//反转链表的递归写法
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next=head;
        head.next = null;
        return cur;
    }
}