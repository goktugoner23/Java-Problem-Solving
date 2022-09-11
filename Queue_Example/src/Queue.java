public class Queue {
    Node head;
    Node tail;
    public Queue(){
        head = null;
        tail = null;
    }
    public class Node{
        Node next;
        int value;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public void enQueue(int value){
        Node newNode = new Node(value, null);
        if (head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
    }
    public int deQueue(){
        if(head == null){
            throw new IllegalStateException("Queue empty");
        }
        Node temp = head;
        head = head.next;
        if(head == null){ //special case for tail
            tail = null;
        }
        temp.next = null;
        return temp.value;
    }
    public int indexOf(int value){
        Node temp = head;
        int index = 0;
        while(temp != null){
            if(temp.value == value){
                return index;
            }
            temp = temp.next;
            index ++;
        }
        return -1;
    }
    public int size(){
        int size = 0;
        for(Node temp = head; temp != null; temp = temp.next){
            size ++;
        }
        return size;
    }
    public void clearAll(){
        while(head != null){
            deQueue();
        }
    }
}
