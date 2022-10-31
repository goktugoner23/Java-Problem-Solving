package main.java;/*Implement a function to check if a tree is balanced. For the purposes of this question,
a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.*/
import java.util.ArrayList;
import java.util.List;

public class TreeIsBalanced {
    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return false;
        }
        int depth = 0;
        List<Integer> depthList = new ArrayList<Integer>();
        getDepth(root, 0, depthList);
        //check the depth difference
        return depthList.stream().max(Integer::compare).get() - depthList.stream().min(Integer::compare).get() <= 1;
    }

    private static void getDepth(TreeNode node, int d, List<Integer> leafDepth){
        if(isLeaf(node)){
            leafDepth.add(d);
        }else{
            getDepth(node.left, d+1, leafDepth);
            getDepth(node.right, d+1, leafDepth);
        }
    }

    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    //recursive solution
    /*public static boolean isBalanced(TreeNode root){
        return (maxDepth(root) - minDepth(root) <= 1);
    }
    private static int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
    private static int minDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }*/
}
