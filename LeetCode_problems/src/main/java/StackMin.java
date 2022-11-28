/*How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
Push, pop and min should all operate in O(1) time.*/
package main.java;

public class StackMin {

    StackNode top;
    StackNode min;

    public void push(int value){
        if (top == null){
            top = new StackNode();
            top.value = value;
            min = top;
            return;
        }
        StackNode temp = new StackNode();
        temp.value = value;
        temp.next = top;
        if(temp.value <= min.value){
            min.nextMin = min;
            min = temp;
        }
        top = temp;
    }

    public int pop(){
        StackNode temp = top;
        if(top == min){
            min = min.nextMin;
        }
        top = top.next;
        int val = temp.value;
        temp = null;
        return val;
    }

    public int min(){
        return min.value;
    }

    public class StackNode{
        int value;
        StackNode next;
        StackNode nextMin; //we also save min value of the stack because we will need it later for O(1).
        public StackNode(){
            this.next = null;
            this.nextMin = null;
        }
    }

    public static void main(String[] args) {
        StackMin asd = new StackMin();
        asd.push(3);
        asd.push(2);
        asd.push(6);
        asd.push(1);
        asd.push(2);
        asd.push(8);
        asd.push(12);
        asd.push(-1);
        asd.pop(); //ERROR
        System.out.println(asd.min());
    }
}


