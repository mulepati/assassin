public class Node<E> {
    E data;
    Node<E> next;
    public Node() {
        this(null, null);
    }
    public Node(E data) {
        this(data, null);
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public boolean equals(Node<E> node) {
        return this.data.equals(node.data);
    }


}