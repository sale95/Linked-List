public class Main {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        SortedLinkedList list3 = new SortedLinkedList();

        list1.add(2);
        list1.add(4);
        list1.add(6);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(9);
        /*
        long currentTime = System.currentTimeMillis();
        // neki dugacak kod
        long finishTime = System.currentTimeMillis();

        long time = finishTime - currentTime;

        System.out.println("Vreme: " + time);
        */
        list3.mergeOptimal(list1, list2);
        list3.printList();
    }
}
