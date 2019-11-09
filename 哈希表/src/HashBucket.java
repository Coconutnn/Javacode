import java.util.Objects;

class Person{
    String sn;

    public Person(String sn) {
        this.sn = sn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(sn, person.sn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sn);
    }
}
public class HashBucket<K,V> {
    public static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next = null;
    }
    private  Node<K,V>[] array =(Node<K,V>[]) new Node[8];
    private int size;
    public V get (K key){
        //1.key =>int
        int hash=key.hashCode();//java中的规定
        int index = hash%array.length;
        Node<K,V> head =array[index];
        for (Node<K,V> cur =head;cur!=null;cur = cur.next){
            if(key.equals(cur.key)){
                return cur.value;
            }
        }
        return null;
    }
}
