//Do kth smallest element in BST solution with inorder traversal.
package main.java;

public class kthSmallestElementinBSTInorder {
    TreeNode root;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        return kthSmallR(root, new Counter(k)).val;
    }

    public TreeNode kthSmallR(TreeNode node, Counter count){
        if(node == null){
            return null;
        }
        TreeNode result = kthSmallR(node.left, count);
        if(result != null){
            return result;
        }
        count.decrement(); //we created a counter class because recursive function does not pass by reference. BECAUSE JAVA
        if(count.isZero()){
            return node;
        }
        result = kthSmallR(node.right, count);
        return result;
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Counter{
        int val;
        Counter(int val){
            this.val = val;
        }
        public void decrement(){
            val--;
        }
        public boolean isZero(){
            return val == 0;
        }
    }

    public void addNode(int value){
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        if (value <= root.val){
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
    private void addNodeP(int value, TreeNode pointer){
        if (value <= pointer.val){
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

    public static void main(String[] args) {
        kthSmallestElementinBSTInorder asd = new kthSmallestElementinBSTInorder();
        asd.addNode(5);
        asd.addNode(3);
        asd.addNode(6);
        asd.addNode(2);
        asd.addNode(4);
        asd.addNode(1);
        System.out.println(asd.kthSmallest(asd.root, 3));
    }
}
