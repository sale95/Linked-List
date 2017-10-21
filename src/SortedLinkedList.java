public class SortedLinkedList extends LinkedList {

    /**
     * This function adds element to the list while maintaining order.
     * @param data value that will be added to the list, while maintaining order.
     */
    @Override
    void add(int data) {
        Node node = new Node(data);
        Node current = head;

        //If list is empty, add to the beginning.
        if (head == null) {
            head = node;
        }
        //If value is less than first element, add it on first position.
        else if(data < current.data) {
            head = node;
            node.next = current;
        }
        //When value higher than data is found, insert new element before that value.
        else {
            while(current.next != null) {
                if(data < current.next.data) {
                    node.next = current.next;
                    current.next = node;
                    return;
                }
                current = current.next;
            }
        }
    }

    /**
     * This function merges two lists.
     * @param list1 First list.
     * @param list2 Second list.
     */
    public void mergeOptimal(LinkedList list1, LinkedList list2) {
        //Check if lists are empty.
        if(list1.head == null && list2.head == null) {
            return;
        } else if(list1.head == null) {
            head = list2.head;
            return;
        } else {
            head = list1.head;
        }

        //Attach bigger list to head.
        if(list1.length > list2.length) {
            head = list1.head;
        } else {
            head = list2.head;
        }

        Node current = list1.head;

        //From smaller list, add every element to bigger list.
        while(current != null) {
            add(current.data);
            current = current.next;
        }
    }
}
