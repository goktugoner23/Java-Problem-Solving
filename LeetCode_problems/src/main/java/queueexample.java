package main.java;

public class queueexample {

    public static class Queue{
        Node head;
        Node tail;
        public class Node{
            Character val;
            Node next;
            public Node(){
            }
            public Node(Character c){
                this.val = c;
            }
        }

        public void add(Character c){
            if(head == null){
                head = new Node(c);
                tail = head;
            }else{
                tail.next = new Node(c);
                tail = tail.next;
            }
        }

        public Character poll(){
            if(head == null){
                return null;
            }
            Character returnVal = head.val;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
            return returnVal;
        }

        public Boolean isEmpty(){
            return head == null;
        }

        public static void main(String[] args) {
            Queue asd = new Queue();
            asd.add('g');
            asd.add('o');
            asd.add('k');
            asd.add('t');
            asd.add('u');
            asd.add('g');

            while(!asd.isEmpty()){
                System.out.print(asd.poll());
            }
        }
    }
}
