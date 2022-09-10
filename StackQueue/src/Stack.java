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
            System.out.println("stack empty");
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
            System.out.println("stack empty");
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

    public boolean checkInFix(String string){
        boolean isTrue = false;
        Stack checkStack = new Stack();
        for(int i=0; i < string.length(); i++){
            if (string.charAt(i) == ')' || string.charAt(i) == ']' || string.charAt(i) == '}' ||
                    string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{'){
                checkStack.push(String.valueOf(string.charAt(i)));
            }
        }
        //now checkStack has all the brackets.
        Node temp = checkStack.top;
        int counter1 = 0, counter2 = 0, counter3 = 0, counter4 = 0, counter5 = 0, counter6 = 0;
        while(temp != null){
            if (temp.getValue().equals(")")){
                counter1 ++;
            }else if (temp.getValue().equals("]")){
                counter2 ++;
            }else if (temp.getValue().equals("}")){
                counter3 ++;
            }else if (temp.getValue().equals("(")){
                counter4 ++;
            }else if (temp.getValue().equals("[")){
                counter5 ++;
            }else if (temp.getValue().equals("{")){
                counter6 ++;
            }
            temp = temp.getNext();
        }
        //in case of there's nothing in stack in terms of brackets
        if(counter1 == 0 && counter2 == 0 && counter3 == 0 && counter4 == 0 && counter5 == 0 && counter6 == 0){
            return false;
        }else if (counter1 == counter4 && counter2 == counter5 && counter3 == counter6){
            isTrue = true;
        }
        checkStack.printStack();
        return isTrue;
    }
}


