/*回文链表
示例 1：
输入： 1->2
输出： false 

示例 2：
输入： 1->2->2->1
输出： true*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode h1 = head;
        while(h1!=null){
            length++;
            h1=h1.next;
        }
        int size = length/2;
        ListNode h2 = null;
        for(int i=0;i<size;i++){
            ListNode pre = head;
            head = head.next;
            pre.next =null;
            if(h2==null){
                h2 =pre;
            }else{
                pre.next =h2;
                h2 =pre;
            }
        }
        if(length%2==1){
            head =head.next;
        }
        while(head!=null){
            if(head.val==h2.val){
                head =head.next;
                h2=h2.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
