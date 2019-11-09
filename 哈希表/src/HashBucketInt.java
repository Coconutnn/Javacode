public class HashBucketInt {
    public static class Node{
        private int key;
        private int value;
        private  Node next=null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array = new Node[8];
    private int size = 0;

    public  int get(int key) {
        int index = key%array.length;
        Node head = array[index];
        for(Node cur = head;cur!=null;cur = cur.next){
            if(key==cur.key){
                return cur.value;
            }
        }
        return -1;
    }
    public int remove(int key){
        int index = key%array.length;
        Node head = array[index];
        if(head!=null&&key==head.key){
            array[index] =array[index].next;
            return head.value;
        }
        Node prev = null;
        for(Node cur = head;cur!=null;cur = cur.next){
            if(key==cur.key){
                prev.next = cur.next;
                return cur.value;
            }
            prev = cur;
        }
        return -1;
    }
}
