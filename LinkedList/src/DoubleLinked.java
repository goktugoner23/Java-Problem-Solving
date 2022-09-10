public class DoubleLinked {
    DNode head;
    DNode tail;

    public DoubleLinked(){
        head = null;
        tail = null;
    }

    public void addNode(int value) {
        DNode newNode = new DNode(value, null, null);
        if (head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void addAfter(int value, int newValue){
        DNode newNode = new DNode(newValue, null, null);
        if (head == null){
            addNode(newValue);
            System.out.println("added to the end cuz the list is empty");
        }else{
            DNode nodeBefore = searchNode(value);
            if (nodeBefore == null){
                addNode(newValue);
                System.out.println("added to the end cuz its not in the list");
                return;
            }
            if (nodeBefore == tail){
                addNode(newValue);
                return;
            }
            DNode nodeAfter = nodeBefore.getNext();
            nodeBefore.setNext(newNode);
            newNode.setPrev(nodeBefore);
            nodeAfter.setPrev(newNode);
            newNode.setNext(nodeAfter);
        }
    }

    /**
     *
     * @param value
     * @return null or node with value
     */
    public DNode searchNode(int value){
        DNode iterator = head;
        while(iterator != null && iterator.getValue() != value){
            iterator = iterator.getNext();
        }
        return iterator;
    }

    public void deleteNode(int value) {
        if (head == null){
            System.out.println("can't delete, no element");
            return;
        }
        if (head.getValue() == value){
            DNode temp = head;
            head = head.getNext();
            temp.setNext(null);
        }else{
            DNode prev = head;
            DNode current = head.getNext();
            while(current != null && current.getValue() != value){
                prev = current;
                current = current.getNext();
            }
            if (current == null){
                System.out.println("can't delete, no element");
            }else if(current == tail){
                tail = tail.getPrev();
                tail.setNext(null);
            }
            else{
                current.getNext().setPrev(prev);
                prev.setNext(current.getNext());
                current.setNext(null);
            }
        }
    }

    public void clearAll(){
        if (head == null){
            return;
        }
        DNode current = head;
        while(current != null){
            DNode temp = current;
            current = current.getNext();
            temp.setNext(null);
            temp.setPrev(null);
        }
        head = null;
        tail = null;
    }

    public String printList(){
        StringBuilder builder = new StringBuilder("[");
        if (head == null){
            builder.append("]");
            return builder.toString();
        }
        DNode iterator = head;
        while(iterator != null){
            builder.append(iterator.getValue());
            builder.append(' ');
            iterator = iterator.getNext();
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    public boolean divisionByEleven(){
        if (head == null){
            System.out.println("list empty");
            return false;
        }
        DNode node = tail;
        int sum = 0;
        int negator = 1;
        while (node != null) {
            sum += node.getValue() * negator;
            node = node.getPrev();
            negator = -negator;
        }
        return sum % 11 == 0;
    }
}

class DNode{
    int value;
    DNode next;
    DNode prev;

    public DNode(int value, DNode next, DNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public DNode getNext(){
        return next;
    }
    public DNode getPrev() { return prev; }

    public int getValue(){
        return value;
    }
    public void setValue(int value) { this.value = value; }
    public void setNext(DNode next)
    {
        this.next = next;
    }
    public void setPrev(DNode prev) { this.prev = prev; }
}