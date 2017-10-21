public class DoublyLinkedList extends LinkedList {
    /**
     * This function adds value to the list.
     * @param data value that will be added to the list.
     */
    @Override
    void add(int data) {
        Node node = new Node(data);
        Node current = head;

        //If list is empty.
        if(head == null) {
            head = node;
        }
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.previous = current;
        }
        length++;
    }

    /**
     * This function adds value on the specific position.
     * @param pos Position where we want to add element.
     * @param value Value of element that we want to add.
     */
    @Override
    void addToPosition(int pos, int value) {
        Node node = new Node(value);
        Node current = head;

        //If position is negative.
        if(pos < 0) {
            System.out.println("Position can't be negative.");
        }
        //If position is higher than length, add to the end of the list.
        else if(pos > length - 1) {
            add(value);
        }
        //If position is 0.
        else if(pos == 0) {
            head = node;
            node.next = current;
        }
        else {
            for(int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            Node after = current.next;

            current.next = node;
            node.next = after;
            node.previous = current;
            after.previous = node;
        }
    }

    /**
     * This function removs element from specific position.
     * @param pos index of element that will  be removed.
     */
    @Override
    void removeFrom(int pos) {
        Node current = head;

        for(int i = 0; i < pos - 1; i++) {
            current = current.next;
        }

        //Node that will be removed.
        Node target = current.next;

        if(pos == 0) {
            head = target;
        }
        //If node is in the last place in the list.
        else if(target.next == null) {
            current.next = null;
        }
        else {
            current.next = target.next;
            target.next.previous = current;
            target.next = null;
            target.previous = null;
        }

    }
}
