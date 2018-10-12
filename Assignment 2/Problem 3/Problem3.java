public class LinkedList {

    private class Node {
        int value;
        Node next;

        Node(int value,  Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node first;



    public LinkedList() {
        first = new Node(0,  null);
    }

    public void add(int a) {
        Node temp = new Node(a,  null);
        Node temp2 = first.next;
        first.next = temp;
        temp.next = temp2;
    }

    public void printList() {
        Node cur  = first.next;
        System.out.print("[");
        while (cur != null) {
            System.out.print(cur.value);
            if (cur.next != null) {
                System.out.print(", ");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }

    private void printCurrent(Node smaller, Node larger, Node head)
    {
        System.out.print("Current list [");
        Node cur = smaller;
        while(cur != null)
        {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        cur = larger;
        while (cur != null)
        {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        cur = head;
        while (cur != null)
        {
            System.out.print(cur.value );
            if(cur.next != null)
            {
                System.out.print(", ");
            }
            cur  = cur.next;
        }
        System.out.println("]");
    }


    public void quicksort()
    {
        first.next = sortList(first.next);
    }


    private Node sortList(Node head) {
        if (head == null || head.next == null) return head;
        int value = head.value;
        Node smaller = null;
        Node smaller_head = null;
        Node mid = head;
        Node larger = null;
        Node larger_head = null;
        Node iter = head.next;
        while (iter != null) {

            System.out.println("compare"+ iter.value + " with pivot" + value);
            if (iter.value < value) {
                if (smaller_head == null) {
                    smaller_head = iter;
                }
                else {
                    smaller.next = iter;
                }
                smaller = iter;
            }
            else if (iter.value == value) {
                mid.next = iter;
                mid = iter;

            }
            else {
                if (larger_head == null) {
                    larger_head = iter;
                }
                else {
                    larger.next = iter;
                }
                larger = iter;
            }
            iter = iter.next;
        }
        if (smaller != null)
            smaller.next = null;
        if (larger != null) larger.next = null;

        printCurrent(smaller_head, larger_head, head);






        mid.next = sortList(larger_head);

        if (smaller == null) {
            return head;
        }
        smaller_head = sortList(smaller_head);
        smaller = smaller_head;
        while (smaller.next != null) smaller = smaller.next;
        smaller.next = head;
        return smaller_head;
    }


}


