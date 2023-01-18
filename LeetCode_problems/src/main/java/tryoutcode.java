package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class tryoutcode {

    public static class Tree{
        TreeNode root;

        public static class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            public TreeNode(int val){
                this.val = val;
            }
            public TreeNode(int val, TreeNode left, TreeNode right){
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public List<Integer> printDFS(TreeNode root){
            if(root == null){
                return null;
            }
            List<Integer> returnList = new ArrayList<>();
            Stack<TreeNode> depot = new Stack<>(); //stack class queue interface o yüzden queue linkedlist kullanır.
            depot.add(root);
            while(!depot.isEmpty()){
                TreeNode current = depot.pop();
                returnList.add(current.val);
                if(current.right != null){
                    depot.add(current.right);
                }
                if(current.left != null){
                    depot.add(current.left);
                }
            }
            return returnList;
        }

        public void printDFSRec(TreeNode node){
            if(node == null){
                return;
            }
            System.out.println(node.val);
            printDFSRec(node.left);
            printDFSRec(node.right);
        }

        public void addNode(int val, TreeNode node){
            if(root == null){
                root = new TreeNode(val);
            }else{
                if(val < node.val){
                    if(node.left == null){
                        node.left = new TreeNode(val);
                    }else{
                        addNode(val, node.left);
                    }
                }else{
                    if(node.right == null){
                        node.right = new TreeNode(val);
                    }else{
                        addNode(val, node.right);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Tree tr = new Tree();
        tr.addNode(3, null);
        tr.addNode(4, tr.root);
        tr.addNode(5, tr.root);
        tr.addNode(2, tr.root);
        tr.addNode(7, tr.root);
        tr.addNode(1, tr.root);
        tr.printDFSRec(tr.root);
        System.out.println(tr.printDFS(tr.root));
    }
}
