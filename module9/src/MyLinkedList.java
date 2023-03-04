import org.w3c.dom.Node;

public class MyLinkedList<T> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node<T> last;

    public MyLinkedList() {
        this.size = 0;
    }

    public void add(T value) {
        Node<T> next = new Node<T>(this.last, value, null);

        System.out.println("ADDED " + value);

        if (this.last != null) {
            this.last.next = next;
        }

        this.last = next;
        this.size++;
    }

    public void remove(int index) {
        if (this.last != null && index >= 0 && index < this.size) {
            Node<T> nodeForRemove = this.last;

            for (int i = this.size - 1; i >= 0; i--) {
                if (index == i) {
                    break;
                }

                nodeForRemove = nodeForRemove.prev;
            }

            Node<T> prevNode = nodeForRemove.prev;
            Node<T> nextNode = nodeForRemove.next;

            if (prevNode != null) {
                prevNode.next = nextNode;
            }

            if (nextNode != null) {
                nextNode.prev = prevNode;
            }

            if (index == this.size - 1) {
                this.last = this.last.prev;
            }

            this.size--;
        }
    }

    public void clear() {
        this.size = 0;
        this.last = null;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index >= 0 && index < this.size) {
            Node<T> node = this.last;

            for (int i = this.size - 1; i >= 0; i--) {
                if (index == i) {
                    break;
                }

                node = node.prev;
            }

            return node.item;
        }

        return null;
    }
}
