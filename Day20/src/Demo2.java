import java.util.*;
//给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
//
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

public class Demo2 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode Shead =new ListNode(0);
        ListNode Bhead = new ListNode(0);
        ListNode cur =pHead;
        ListNode stmp = Shead;
        ListNode btmp = Bhead;
        while(cur!=null){
            if(cur.val<x){
                stmp.next = new ListNode(cur.val);
                stmp = stmp.next;
            }
            else{
                btmp.next = new ListNode(cur.val);
                btmp = btmp.next;
            }
            cur = cur.next;
        }
        cur = Shead;
        while(cur.next!=null){
            cur = cur.next;

        }
        cur.next = Bhead.next;
        return Shead.next;
    }

}