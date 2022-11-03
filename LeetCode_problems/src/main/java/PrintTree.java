package main.java;

import java.sql.Array;
import java.util.*;

public class PrintTree {
    static TreeNode root;
    public static List<Integer> printBFS(){
        if (root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> depot = new LinkedList<>();
        depot.add(root);
        while(!depot.isEmpty()){
            TreeNode temp = depot.poll();
            list.add(temp.val);
            if(temp.left != null){
                depot.add(temp.left);
            }
            if(temp.right != null){
                depot.add(temp.right);
            }
        }
        return list;
    }

    public static List<Integer> printSorted(){
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        sortBinaryTreeInorder(root, list);
        return list;
    }

    private static void sortBinaryTreeInorder(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        sortBinaryTreeInorder(node.left, list);
        list.add(node.val);
        sortBinaryTreeInorder(node.right, list);
    }

    public void addNodeP(int val, TreeNode node){
        if(val <= node.val){
            if(node.left != null){
                addNodeP(val, node.left);
            }else{
                node.left = new TreeNode(val, null, null);
            }
        }else{
            if(node.right != null){
                addNodeP(val, node.right);
            }else{
                node.right = new TreeNode(val, null, null);
            }
        }
    }

    public void addNode(int value){
        if (root == null) {
            root = new TreeNode(value, null, null);
            return;
        }
        if (value <= root.val){
            if (root.left != null){
                addNodeP(value, root.left);
            }else{
                root.left = new TreeNode(value, null, null);
            }
        }else{
            if (root.right != null){
                addNodeP(value, root.right);
            }else{
                root.right = new TreeNode(value, null, null);
            }
        }
    }
    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        PrintTree asd = new PrintTree();
        asd.addNode(1);
        asd.addNode(2);
        asd.addNode(4);
        asd.addNode(3);
        asd.addNode(7);
        asd.addNode(6);
        asd.addNode(9);
        asd.addNode(3);
        System.out.println(printBFS());
        System.out.println(printSorted());
    }
}
