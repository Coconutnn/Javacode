/*链表相交
示例 1：

输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1!=h2){
            if(h1==null){
                h1=headB;
            }else{
                h1=h1.next;
            }
            if(h2==null){
                h2=headA;
            }else{
                h2=h2.next;
            }
        }
        
        return h1;
    }
}