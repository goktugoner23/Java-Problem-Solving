package main.java;

public class LinkedList {
    Node head;
    public class Node{
        int value;
        Node next;

        public Node getNext(){
            return next;
        }

        public void setNext(Node node){
            this.next = node;
        }
    }

    public int size(){
        Node temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size ++;
        }
        return size;
    }

    public void add(int value){
        Node newNode = new Node();
        newNode.next = head;
        newNode.value = value;
        head = newNode;
    }

}
