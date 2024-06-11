package main.java;

public class stackexample {

    public static class Stack{
        Node top;
        public static class Node{
            int val;
            Node next;

            public Node(){
                this.val = 0;
                this.next = null;
            }
            public Node(int val){
                this.val = val;
                this.next = null;
            }
        }

        public void push(int val){
            if(top == null){
                top = new Node(val);
            }else{
                Node temp = new Node(val);
                temp.next = top;
                top = temp;
            }
        }

        public int pop() throws Exception {
            if(top == null){
                throw new Exception("stack empty");
            }
            Node temp = top;
            top = top.next;
            int tempval = temp.val;
            temp = null;
            return tempval;
        }

        public void printStack(){
            if(top == null){
                System.out.println("stack empty");
                return;
            }
            Node temp = top;
            while(temp != null){
                System.out.println(temp.val);
                temp = temp.next;
            }
        }

        public static void main(String[] args) throws Exception{
            Stack asd = new Stack();
            asd.push(2);
            asd.push(3);
            asd.push(5);
            asd.push(7);
            asd.push(1);
            asd.push(4);
            asd.pop();
            asd.printStack();
        }
    }
}
