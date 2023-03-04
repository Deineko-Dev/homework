import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {
    private static class Node<K,V> {
        int hashCode;
        final K key;
        final V value;
        Node<K,V> nextNode;

        Node(int hashCode, K key, V value) {
            this.hashCode = hashCode;
            this.key = key;
            this.value = value;
            this.nextNode = null;
        }
    }

    Object[] list = new Object[16];
    int size = 0;

    public void put(K key, V value) {
        int hashValue = Objects.hash(key);
        int index = hashValue & (this.list.length-1);

        if (this.list[index] == null) {
            this.list[index] = new Node<K, V>(hashValue, key, value);
            this.size++;
        } else {
            Node<K,V> currentNode = (Node<K,V>) this.list[index];
            boolean isSetNode = false;

            while(currentNode.nextNode != null) {
                if (currentNode.hashCode == hashValue && currentNode.key == key){
                    isSetNode = true;
                }

                currentNode = currentNode.nextNode;
            }

            if (!isSetNode) {
                currentNode.nextNode = new Node<K, V>(hashValue, key, value);
                this.size++;
            }
        }
    }

    public V get(K key) {
        int hashValue = Objects.hash(key);
        int index = hashValue & (this.list.length-1);

        if (this.list[index] != null) {
            Node<K,V> currentNode = (Node<K,V>) this.list[index];
            boolean isBreak = false;

            while(!isBreak) {
                if (currentNode.hashCode == hashValue && currentNode.key == key) {
                    return currentNode.value;
                }

                isBreak = currentNode.nextNode == null;
                currentNode = currentNode.nextNode;
            }
        }

        return null;
    }

    public void remove(K key) {
        int hashCode = Objects.hash(key);
        int index = hashCode & (this.list.length-1);
        Node<K,V> node = (Node<K,V>) this.list[index];

        if (node == null) {
            return;
        }

        if (node.hashCode == hashCode && node.key == key) {
            this.list[index] = node.nextNode;
            this.size--;
            return;
        }

        while(node != null) {
            if (node.nextNode != null && node.nextNode.hashCode == hashCode && node.nextNode.key == key) {
                node.nextNode = node.nextNode.nextNode;
                this.size--;
                return;
            }

            node = node.nextNode;
        }
    }

    public void clear() {
        this.size = 0;
        list = new Node[16];
    }

    public int size() {
        return this.size;
    }
}
