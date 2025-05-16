package datastructures.LinkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    /* Create a constructor for a LinkedList class that initializes a new linked list with a single node. */
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead(){
        return head;
    }

    public Node getTail(){
        return tail;
    }

    public int getLength(){
        return length;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("Length: " + length);
    }

    public void emptyList(){
        head = tail = null;
        length = 0;
    }

    /*
        Implement the append method that appends a new node to the end of the linked list.

        Return type: void
     */
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0 ){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /*
        Implement a method called removeLast that removes the last node from the linked list.

        Return type: Node (we are returning the Node that is being removed)
     */
    public Node removeLast(){

        if(length == 0) return null;

        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if( length == 0 ){
            head = null;
            tail = null;
        }
        return temp;
    }

    /*
        Implement a method called prepend that adds a new node at the beginning of the linked list.

        Return type: void
     */
    public void prepend( int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /*
        Implement a method called removeFirst that removes the first node from the linked list and returns it.

        Return type: Node (the node that is removed)
     */
    public Node removeFirst(){
        if(length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if(length == 0){
            tail = null;
        }
        return temp;
    }

    /*
        Implement a method called get that retrieves a node from the linked list by its index.

        Return type: Node
     */
    public Node get(int index){
        if(index <0 || index >=length){
            return null;
        }
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    /*
        Implement a method called set that updates the value of a node in the linked list by its index.

        Return type: boolean

        Method signature: public boolean set(int index, int value)
     */
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    /*
        Implement a method called insert that inserts a new node at a specified index in the linked list.

        Return type: boolean

        Method signature: public boolean insert(int index, int value)
     */
    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;

        if(index == 0) {
            prepend(value);
            return true;
        }

        if(index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    /*
        Implement a method called remove that removes a node at a specified index in the linked list.

        Return type: Node (the node that has been removed)
     */
    public Node remove(int index){
        if(index <0 || index >= length) return null;
        if(index == 0) return removeFirst();
        if(index == length - 1) return removeLast();

        Node temp = get(index);
        Node prev = get(index -1);
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    /*
        Implement a method called reverse that reverses the order of the nodes in the linked list.

        When solving the reverse() method, students are not allowed to create a new list or use any additional data structures besides the linked list itself.

        They must reverse the nodes in the existing linked list by manipulating the pointers between them.

        Return type: void

        The process of reversing the linked list should be done in one pass of the linked list.

        Create a temporary Node object called temp and set it to the head attribute of the list.

        Set the head attribute of the list to the current tail attribute.

        Set the tail attribute of the list to the temporary Node object.

        Create a Node object called after and set it to the next attribute of the temporary Node object.

        Create a Node object called before and initialize it to null.

        Loop through the linked list using a for loop with a counter variable i, starting from 0 and ending at the length attribute of the list. a. Set the after attribute to the next attribute of the temporary Node object. b. Set the next attribute of the temporary Node object to the before attribute. c. Set the before attribute to the temporary Node object. d. Set the temporary Node object to the after attribute.
     */
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;
        for(int i=0; i< length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }


    public Node findMiddleNode(){

        // if(head == null || tail == null) return null;
        // if(head.next == null) return head;

        Node fastPointer = head;
        Node slowPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            // Move the fast pointer by two nodes
            fastPointer = fastPointer.next.next;
            // Move the slow pointer by one node
            slowPointer = slowPointer.next;
        }
        // Return the slow pointer which is currently
        // pointing to the middle node of the linked list
        return slowPointer;

    }

    /*
        You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.

        This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.

        The method should follow these guidelines:

        Create two pointers, slow and fast, both initially pointing to the head of the linked list.

        Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.

        If there is a loop in the list, the fast pointer will eventually meet the slow pointer. If this occurs, the method should return true.

        If the fast pointer reaches the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.

        Output:

        Return true if the linked list has a loop.

        Return false if the linked list does not have a loop.
     */
    public boolean hasLoop(){

        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer) return true;

        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        /*int len =0;

        Node temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }

        temp = head;
        if(len < k)
            return null;

        for(int i=0; i < len-k; i++){
            temp = temp.next;
        }
        return temp;
         */

        // efficient approach -> slow and fast pointer
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null)
                return null;

            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
