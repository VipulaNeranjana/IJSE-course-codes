package lk.ijse.dep10.Util;

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    Node previousNode;
    Node nextNode;

    private int size;


    public void add(String value) {
        Node node = new Node(Integer.parseInt(value), null);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;


        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = head;
        size = 0;
    }

    public String get(int index) {
        Node wantedNode = head;
        for (int i = 0; i < index; i++) {
            wantedNode = wantedNode.next;
        }
        return Integer.toString(wantedNode.data);
    }

    public boolean contains(String value) {
        Node wantedNode = head;
        for (int i = 0; i < size; i++) {

            if (wantedNode.data == Integer.parseInt(value)) return true;
            wantedNode = wantedNode.next;
        }
        return false;

    }

    public void remove(int index) {
        if (size == 0 || index < 0 || index > size) return;

        if (index == 0) {
            head = head.next;
        } else {
            Node intermediate = head;
            for (int i = 0; i < index - 1; i++) {
                intermediate = intermediate.next;
            }
            if (index == size) {
                intermediate.next = null;
                tail = intermediate;
            }

            intermediate.next = intermediate.next.next;
        }

    }

    @Override
    public String toString() {
        String data = "[";
        Node temp = head;
        while (temp != null) {
            data += " " +temp.data+",";
            temp = temp.next;
        }
        data += "\b";
        data += "]";

        return data;
    }
}

class Node {
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    int data;
    Node next;
}
