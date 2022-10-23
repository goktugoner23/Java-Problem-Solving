package main.test;

import main.java.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @org.junit.jupiter.api.Test
    void addNode() {
    }

    @org.junit.jupiter.api.Test
    void printDFS() {
        Tree newTree = new Tree();
        newTree.addNode(3);
        newTree.addNode(2);
        newTree.addNode(3);
        newTree.addNode(1);
        newTree.addNode(4);
        newTree.printDFT();
        newTree.printBFT();
    }

    @Test
    void binarySearch() {
        Tree newTree = new Tree();
        newTree.addNode(12);
        newTree.addNode(3);
        newTree.addNode(5);
        newTree.addNode(1);
        newTree.addNode(14);
        Tree.TreeNode asd = newTree.binarySearch(3);
        Assertions.assertNotNull(asd);
        Assertions.assertNotNull(asd.getLeft());
        Assertions.assertNotNull(asd.getRight());
        Assertions.assertEquals(3, asd.getValue());
        Assertions.assertEquals(1, asd.getLeft().getValue());
        Assertions.assertEquals(5, asd.getRight().getValue());
    }

    @Test
    void binaryRecursiveSearch() {
        Tree newTree = new Tree();
        newTree.addNode(12);
        newTree.addNode(3);
        newTree.addNode(5);
        newTree.addNode(1);
        newTree.addNode(14);
        Tree.TreeNode asd = newTree.binaryRecursiveSearch(3);
        Assertions.assertNotNull(asd);
        Assertions.assertNotNull(asd.getLeft());
        Assertions.assertNotNull(asd.getRight());
        Assertions.assertEquals(3, asd.getValue());
        Assertions.assertEquals(1, asd.getLeft().getValue());
        Assertions.assertEquals(5, asd.getRight().getValue());
    }

    @Test
    void preorderPrintTree() {
        Tree newTree = new Tree();
        newTree.addNode(12);
        newTree.addNode(3);
        newTree.addNode(5);
        newTree.addNode(1);
        newTree.addNode(14);
        newTree.preorderPrintTree();
    }

    @Test
    void postorderPrintTree() {
        Tree newTree = new Tree();
        newTree.addNode(12);
        newTree.addNode(3);
        newTree.addNode(5);
        newTree.addNode(1);
        newTree.addNode(14);
        newTree.postorderPrintTree();
    }

    @Test
    void inorderPrintTree() {
        Tree newTree = new Tree();
        newTree.addNode(12);
        newTree.addNode(3);
        newTree.addNode(5);
        newTree.addNode(1);
        newTree.addNode(14);
        newTree.inorderPrintTree();
    }
}