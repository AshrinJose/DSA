package datastructures.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);

        myLinkedList.append(2);
        System.out.println("Current LinkedList: " );
        myLinkedList.printList();
        System.out.println("----------------");

        System.out.println("Remove Last Element");
        System.out.println("The value removed is " + myLinkedList.removeLast().value);
        System.out.println("List after removing last element");
        myLinkedList.printList();
        System.out.println("----------------");

        System.out.println("Before prepend():");
        System.out.println("-----------------");
        myLinkedList.printList();
        myLinkedList.prepend(1);
        System.out.println("\n\nAfter prepend():");
        System.out.println("----------------");
        myLinkedList.printList();

        System.out.println("Remove First Element");
        System.out.println("The value removed is " + myLinkedList.removeFirst().value);
        System.out.println("List after removing first element");
        myLinkedList.printList();
        System.out.println("----------------");

        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.printList();
        System.out.println("Get node at an index 0");
        System.out.println(myLinkedList.get(0).value);
        System.out.println("Get node at an index 2");
        System.out.println(myLinkedList.get(2).value);
        System.out.println("----------------");

        System.out.println("Linked List before set():");
        myLinkedList.printList();
        myLinkedList.set(2, 99);
        System.out.println("\nLinked List after set():");
        myLinkedList.printList();
        System.out.println("----------------");


        System.out.println("LL before insert():");
        myLinkedList.printList();
        myLinkedList.insert(1, 2);
        System.out.println("\nLL after insert(2) at index 1:");
        myLinkedList.printList();
        myLinkedList.insert(0, 0);
        System.out.println("\nLL after insert(0) at beginning:");
        myLinkedList.printList();
        myLinkedList.insert(4, 4);
        System.out.println("\nLL after insert(4) at index 4:");
        myLinkedList.printList();
        System.out.println("----------------");

        System.out.println("LL before remove():");
        myLinkedList.printList();
        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("LL after remove() in index 2:");
        myLinkedList.printList();
        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(0).value);
        System.out.println("LL after remove() of first node:");
        myLinkedList.printList();
        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("LL after remove() at index 2:");
        myLinkedList.printList();
        System.out.println("----------------");

        System.out.println("LL before reverse():");
        myLinkedList.printList();
        myLinkedList.reverse();
        System.out.println("\nLL after reverse():");
        myLinkedList.printList();
        System.out.println("----------------");

        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);
        myLinkedList.insert(2,2);
        myLinkedList.printList();
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);
    }
}
