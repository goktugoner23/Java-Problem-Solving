
public class Queue {
    Stack stack1;
    Stack stack2;
    public Queue(){
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void enQueue(String value){
        stack1.push(value);
    }

    public void deQueue(){
        if (stack1.top == null && stack2.top == null){
            System.out.println("Queue is empty");
            System.exit(0);
        }
        //move elements to stack1 if stack2 is empty
        if (stack2.top == null){
            while (stack1.top != null){
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    public void printQueue(){
        System.out.println("STACK 1");
        stack1.printStack();
        System.out.println("STACK 2");
        stack2.printStack();
    }
}
