class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newhead = new ListNode(0);
        ListNode tail = newhead;
        while(true){
            int min =-1;
            for(int i=0;i<lists.length;i++){
                if(lists[i]==null){
                    continue;
                }
                if(min==-1||lists[min].val>lists[i].val){
                    min =i;
                }
            }
            if(min==-1){
                break;
            }
            tail.next = lists[min];
            tail = tail.next;
            lists[min]=lists[min].next;

        }
        return newhead.next;
    }
}