package main.test;

import main.java.LinkedList;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void sizeTest() {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(3);
        Assertions.assertEquals(2, list.size());
    }
}