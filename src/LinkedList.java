import sun.awt.image.ImageWatched;

class LinkedList {
    protected Node head;
    protected int length = 0;
    protected Node last;

    /**
     * This function adds a number to the list.
     * @param data value that will be added to the list.
     */
    void add(int data) {
        Node node = new Node(data);

        //If list is empty, add node as first element.
        if (head == null) {
            head = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        length++;
    }

    /**
     * This function prints the list.
     */
    void printList() {
        //If list is empty.
        if(head == null) {
            return;
        }
        else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    }

    /**
     * This function removes the element from the given position.
     * @param pos index of element that will  be removed.
     */
    void removeFrom(int pos) {
        int size = length - 1;

        //If list is empty.
        if (head == null) {
            System.out.println("List is empty");
        }
        //If there is more than one element in the list and position is 0.
        else if (pos == 0) {
            head = head.next;
            length--;
        }
        //If position is higher than size of the list.
        else if (pos > size || pos < 0) {
            System.out.println("There is no such position. Currently, min position is 0, max is " + size + ".");
        }
        //For every situation where position is higher than 0 and lower than the list size.
        else {
            Node current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            Node toDelete = current.next;
            current.next = toDelete.next;
            length--;
        }
    }

    /**
     * This function finds the average value of the list.
     * @return Returns double which represents average value of the list.
     */
    double avg() {
        double sum = 0.0;
        double avg;

        if(head == null) {
            return 0.0;
        } else {
            Node current = head;
            while(current != null) {
                sum = sum + current.data;
                current = current.next;
            }
            avg = sum / length;
        }
        return avg;
    }

    /**
     * This function searches for the node with the given value, and returns it's position if exists, -1 if not.
     * @param value element that we search for.
     * @return Returns positive int that represents positon of element, -1 if that element diesn't exist.
     */
    int searchFor(int value) {
        Node current = head;
        int pos = 0;

        while (current != null) {
            if (current.data == value) {
                return pos;
            }
            current = current.next;
            pos++;
        }
        return -1;
    }

    /**
     * This function compares two elements and returns the element index with bigger value.
     * @param pos1 index of first element that we want to compare.
     * @param pos2 index of second element.
     * @return Returns index of bigger element, -1 if they are equal or positons don't exist.
     */
    int compare(int pos1, int pos2) {
        Node node1 = null;
        Node node2;
        Node current = head;
        int min = 0;
        int max = 0;

        //If arguments are higher than maximum number of arguments return -1;
        if (pos1 > length - 1 || pos2 > length - 1 || pos1 < 0 || pos2 < 0) {
            return -1;
        }

        //Find max and min positions.
        if(pos1 < pos2) {
            min = pos1;
            max = pos2;
        } else if(pos1 > pos2) {
            max = pos1;
            min = pos2;
        } else {
            System.out.println("They are equal");
            return -1;
        }

        //Find first and second node.
        for(int i = 0; i < max; i++) {
            if(i == min) {
                node1 = current;
            }
            current = current.next;
        }
        node2 = current;

        //Compare first and second node.
        //If min index node is bigger, return min index.
        if (node1.data > node2.data) {
            return min;
        }
        //If min index node is smaller, return max index.
        else if (node1.data < node2.data) {
            return max;
        }
        // If they are equal return -1.
        else {
            return -1;
        }
    }

    /**
     * This function returns a list with all nodes which are bigger than given number.
     * @param value Number that we compare nodes with.
     */
    void elementsBigger(int value) {
        Node current = head;
        Node head2 = null; //Head for new list.
        Node current2;

        //Make a new list of bigger elements.
        while(current != null) {
            if(current.data > value) {
                //If new list is empty, add to first place.
                if(head2 == null) {
                    head2 = new Node(current.data);
                }
                else {
                    current2 = head2;
                    while(current2.next != null) {
                        current2 = current2.next;
                    }
                    current2.next = new Node(current.data);
                }
            }
            current = current.next;
        }

        //Print new list.
        current2 = head2;
        while(current2 != null) {
            System.out.print(current2.data + " ");
            current2 = current2.next;
        }

    }

    /**
     * This function adds value to a specific position.
     * @param pos Position where we want to add element.
     * @param value Value of element that we want to add.
     */
    void addToPosition(int pos, int value) {
        Node node = new Node(value);
        Node current = head;

        //If position is higher than maximum number of elements in the list.
        if(pos < 0) {
            System.out.println("Position can't be negative.");
        }
        else if(pos > length-1) {
            add(value);
        }
        else if(pos == 0) {
            node.next = head;
            head = node;
        }
        else {
            for(int i = 0; i < pos-1; i++) {
                current = current.next;
            }
            Node after = current.next;
            current.next = node;
            node.next = after;
        }
    }

    /**
     * This function sorts the list.
     */
    void sortList() {
        Node current;
        int temp;

        for(int i = 0; i < length-1; i++) {
            current = head;
            for(int j = i; j < length-1; j++) {
                if(current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

}
