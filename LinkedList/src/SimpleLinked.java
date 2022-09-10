public class SimpleLinked{
    Node head;
    public SimpleLinked(){
        head = null;
    }

    public void addNode(int value){
        Node newNode = new Node(value, null);
        if (head == null){
            head = newNode;
        }else{
            Node iterator = head;
            while(iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            iterator.setNext(newNode);
        }
    }

    public void deleteNode(int value){ //CHECK HEAD FIRST
        if (head == null){
            System.out.println("can't delete, no element");
            return;
        }
        if (head.getValue() == value){
            Node temp = head;
            head = head.getNext();
            temp.setNext(null);
        }else{
            Node prev = head;
            Node current = head.getNext();
            while(current != null && current.getValue() != value){
                prev = current;
                current = current.getNext();
            }
            if (current == null){
                System.out.println("can't delete, no element");
                return;
            }else{
                prev.setNext(current.getNext());
                current.setNext(null);
            }
        }
    }

    public String printList(){
        StringBuilder builder = new StringBuilder("[");
        if (head == null){
            builder.append("]");
            return builder.toString();
        }
        Node iterator = head;
        while(iterator != null){
            builder.append(iterator.getValue());
            builder.append(' ');
            iterator = iterator.getNext();
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}

class Node{
    int value;
    Node next;

    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    public int getValue(){
        return value;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
}
