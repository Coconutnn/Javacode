/*删除链表中的重复节点
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = pHead;
        while(last!=null){
            //找到重复起始位置
            //如果不相等则两个指针都后移
            while(last.next!=null&&last.val!=last.next.val){
                pre = pre.next;
                last = last.next;
            }
            //找到重复结尾的节点
            while(last.next!=null&&last.val==last.next.val){
                last = last.next;
            }
            if(pre.next!=last){//说明重复了一段，相等则没有重复
                pre.next = last.next;
            }
            last = last.next;
        }
        return head.next;//不能返回pHead，因为有可能头节点就开始重复
    }
}