package main.test;

import main.java.FibMemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibMemoTest {

    @Test
    void fib() {
        FibMemo asd = new FibMemo();
        Assertions.assertEquals(	832040, asd.fib(30, asd.memo));
    }
}