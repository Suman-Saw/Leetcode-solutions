class Node {
    Node next;
    int data;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
    }

    public void makeCircularLinkedList() {
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = head;

    }

    public boolean isCircularLinkedList() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public void traverseList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data + "=>");
            currentNode = currentNode.next;
        }
    }
}
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.traverseList();
        linkedList.makeCircularLinkedList();
        System.out.println("isCircular: " + linkedList.isCircularLinkedList());
    }
}
