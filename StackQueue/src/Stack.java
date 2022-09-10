public class Stack {
    Node top;
    public Stack(){
        top = null;
    }

    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
    public void push(String value){
        Node newNode = new Node(value, top);
        top = newNode;
    }

    public String pop(){
        if(top == null){
            System.out.println("stack boş");
            return null;
        }
        Node temp = top;
        top = top.getNext();
        return temp.getValue();
    }

    public int size(){
        Node temp = top;
        int counter = 0;
        while (temp != null){
            temp = temp.getNext();
            counter ++;
        }
        return counter;
    }

    public String search(String value){
        if (top == null){
            System.out.println("stack boş");
        }
        Node temp = top;
        while(temp != null){
            if(temp.getValue().equals(value)){
                return temp.getValue();
            }
            temp = temp.getNext();
        }
        return null;
    }
}


