package main.java;

import javax.swing.text.StyledEditorKit;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//binary-tree
public class Tree {

    TreeNode root;

    public void addNode(int value){
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        if (value <= root.value){
            if (root.left != null){
                addNodeP(value, root.left);
            }else{
                root.left = new TreeNode(value);
            }
        }else{
            if (root.right != null){
                addNodeP(value, root.right);
            }else{
                root.right = new TreeNode(value);
            }
        }
    }

    public void preorderPrintTree(){
        //homework
    }
    public void postorderPrintTree(){
        //homework
    }
    public void inorderPrintTree(){
        //homework
    }

    public void printDFT(){
        if(root == null){
            System.out.println("main.java.Tree Empty");
            return;
        }
        Stack<TreeNode> depot = new Stack<>();
        depot.push(root);
        while(!depot.isEmpty()){
            TreeNode current = depot.pop();
            System.out.println(current.value);
            if(current.right != null){
                depot.push(current.right);
            }
            if(current.left != null){
                depot.push(current.left);
            }
        }
    }
    public void printBFT(){
        if(root == null){
            System.out.println("main.java.Tree Empty");
            return;
        }
        Queue<TreeNode> depot = new LinkedList<>();
        depot.add(root);
        while(!depot.isEmpty()){
            TreeNode current = depot.poll();
            System.out.println(current.value);
            if(current.left != null){
                depot.add(current.left);
            }
            if(current.right != null){
                depot.add(current.right);
            }
        }
    }

    public TreeNode binarySearch(int value){
        if (root == null){
            System.out.println("Tree Empty");
            return null;
        }
        TreeNode pointer = root;
        while(value != pointer.value){
            if(value < pointer.value){
                pointer = pointer.left;
            }else{
                pointer = pointer.right;
            }
            if(pointer == null){
                return null;
            }
        }
        return pointer;
    }

    public TreeNode binaryRecursiveSearch(int value){
        return searchNodeR(value, root);
    }

    public void deleteNode(int value){
        if (root == null){
            System.out.println("Tree is empty");
            return;
        }
        if(value == root.value){
            TreeNode left = root.left;
            TreeNode right = root.right;
            while(left.right != null){
                left = left.right;
            }
            left.right = right;
        }else{
            TreeNode parent = searchParentNode(value, root);
            if (parent == null){
                System.out.println("couldn't find the node");
                return;
            }
            boolean isLeftChildToBeDeleted = parent.left.value == value; //its the left child
            TreeNode willBeDeleted = isLeftChildToBeDeleted ? parent.left : parent.right;
            if(willBeDeleted.left == null){
                if(isLeftChildToBeDeleted){
                    parent.left = willBeDeleted.right;
                }else{
                    parent.right = willBeDeleted.right;
                }
                return;
            }
            if(isLeftChildToBeDeleted){
                parent.left = willBeDeleted.left;
            }else{
                parent.right = willBeDeleted.left;
            }
            TreeNode temp = willBeDeleted.left;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = willBeDeleted.right;
        }
    }

    public class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
            left = null;
            right = null;
        }

        public TreeNode getLeft(){
            return left;
        }
        public TreeNode getRight(){
            return right;
        }
        public int getValue(){
            return value;
        }

        //another usage of recursion
        /*public void insert(int data){
            if (data <= value){
                if (left == null){
                    left = new TreeNode(data);
                }else {
                    left.insert(data);
                }
            }else{
                if (right == null){
                    right = new TreeNode(data);
                }else{
                    right.insert(data);
                }
            }
        }*/
    }

    private void addNodeP(int value, TreeNode pointer){
        if (value <= pointer.value){
            if (pointer.left != null){
                addNodeP(value, pointer.left);
            }else{
                pointer.left = new TreeNode(value);
            }
        }else{
            if (pointer.right != null){
                addNodeP(value, pointer.right);
            }else{
                pointer.right = new TreeNode(value);
            }
        }
    }

    private TreeNode searchNodeR(int value, TreeNode pointer){
        if (pointer == null){
            System.out.println("couldn't find the element");
            return null;
        }
        if (value == pointer.value){
            return pointer;
        }
        if(value< pointer.value){
            return searchNodeR(value, pointer.left);
        }else{
            return searchNodeR(value, pointer.right);
        }
    }

    private TreeNode searchParentNode(int value, TreeNode node){
        if (node == null){
            return null;
        }
        if ((node.left != null && value == node.left.getValue()) || (node.right != null && value == node.right.getValue())){
            return node;
        }
        if (value < node.value){
            return searchParentNode(value, node.left);
        }
        if (value > node.value){
            return searchParentNode(value, node.right);
        }
        return null;
    }
}
