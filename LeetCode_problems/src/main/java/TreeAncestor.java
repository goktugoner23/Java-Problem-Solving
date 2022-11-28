/*Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure.
NOTE: This is not necessarily a binary search tree.*/
package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeAncestor {
    public static class TreeNode{
        int value;
        List<TreeNode> children;
        TreeNode parent;

        public TreeNode(int value){ //constructor
            this.value = value;
            children = new ArrayList<>();
            this.parent = null;
        }

        public void addChild(TreeNode child){
            children.add(child);
            child.parent = this;
        }

        public TreeNode getParent(){
            return parent;
        }
    }

    public static TreeNode findAncestor(TreeNode l1, TreeNode l2){
        if(l1 == null || l2 == null){
            return null;
        }
        if(l1 == l2){
            return l1.parent;
        }
        Stack<TreeNode> l1Stack = getAncestors(l1);
        Stack<TreeNode> l2Stack = getAncestors(l2);
        TreeNode ancestor = null;
        while(!l1Stack.isEmpty() && !l2Stack.isEmpty()){
            TreeNode temp1 = l1Stack.pop();
            TreeNode temp2 = l2Stack.pop();
            if(temp1 == temp2){
                ancestor = temp1;
            }else{
                break; //means we found the last common parent
            }
        }
        return ancestor;
    }

    private static Stack<TreeNode> getAncestors(TreeNode node){ //we add all the parents of the node to a stack to compare later
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode temp = node;
        while(temp != null){
            nodeStack.push(temp);
            temp = temp.getParent();
        }
        return nodeStack;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(5);
        TreeNode child3 = new TreeNode(12);
        TreeNode child4 = new TreeNode(3);
        root.addChild(child1);
        child1.addChild(child3);
        child3.addChild(child2);
        child1.addChild(child4);
        root.addChild(new TreeNode(4));
        System.out.println(findAncestor(child2, child4).value);
    }
}
