import java.util.NoSuchElementException;

public class LinkedList<E> {
    private Node<E> first;

    public LinkedList() {this.first = null;}


    public LinkedList(E val) {
        this.first = new Node<>(val);
    }

    public void add(Node<E> node) {
        if (first == null) {
            first = node;
        }
        else{
            Node<E> lastNode = getLastNode();
            lastNode.next = node;
        }
    }

    public void add(Node<E> node, int index) {
        Node<E> current = first;
        int indexNode = -1;
        while(indexNode != index) {
            if(current == null || current.next == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
            indexNode++;
        }
        node.next = current.next;
        current.next = node;

    }

    public Node<E> getParent(Node<E> node) {
        if(first == null) {
            throw new NoSuchElementException();
        }
        Node<E> current = first;

        if(current.equals(node)) {
            return null;
        }

        while(current.next != null) {
            Node<E> temp = new Node<>(current.data);
            if(current.next.equals(node)) {
                return temp;
            }
            current = current.next;
        }
        throw new NoSuchElementException();

    }

    public void truncateList(E value) {
        Node<E> current = first;
        if(current.data == value) {
            first = null;
        }
        while(current.next != null) {
            if(current.next.data == value) {
                current.next = null;
                break;
            }
            current = current.next;
        }
    }

    public void remove(Node<E> node) {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<E> current = first;
        if(first.data == node.data) {
            first = current.next;
        }
        else{
            while (current.next.data != node.data ) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public boolean exists(Node<E> node) {
        Node<E> current = first;
        while(current != null) {
            if(current.equals(node)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean equals(LinkedList<E> list) {
        Node<E> current = first;
        Node<E> currentList = list.getFirst();
        while(currentList != null && current != null) {
            if(!currentList.equals(current)) {
                return false;
            }
            currentList = currentList.next;
            current = current.next;
        }

        return true;
    }

    public Node<E> getFirst() {
        return first;
    }

    public Node<E> getLastNode(){
        if(first == null){
            return first;
        } else {
            Node<E> current = first;
            while(current.next != null) {
                current = current.next;
            }
            return current;
        }
    }

    public String toString() {
        Node<E> current = first;
        StringBuilder print = new StringBuilder();
        while(current != null) {
            print.append(current.data + " ");
            current = current.next;
        }
        return print.toString();
    }


}