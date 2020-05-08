/*面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]*/
class Solution {
    public Set<Integer> set = new HashSet<>();
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null)
        return null;
        if(set.contains(head.val)){
            return removeDuplicateNodes(head.next);
        }else{
            set.add(head.val);
            head.next = removeDuplicateNodes(head.next);
            return head;
        }
    }
}