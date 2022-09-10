public class Node {
    Node next;
    String value;

    public Node(String value, Node next){
        this.value = value;
        this.next = next;
    }

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node node){
        this.next = node;
    }
}
