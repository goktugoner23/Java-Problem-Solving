/*https://leetcode.com/problems/kth-smallest-element-in-a-bst/
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?*/
import java.util.*;
public class kthSmallestElementinBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }
        ArrayList<Integer> tree = new ArrayList<>();
        //Depth First Traversal and adding the values to an integer list
        Stack<TreeNode> depot = new Stack<>();
        depot.push(root);
        while(!depot.isEmpty()){
            TreeNode current = depot.pop();
            tree.add(current.val);
            if(current.left != null){
                depot.push(current.left);
            }
            if(current.right != null){
                depot.push(current.right);
            }
        }
        Collections.sort(tree);
        return tree.get(k-1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
