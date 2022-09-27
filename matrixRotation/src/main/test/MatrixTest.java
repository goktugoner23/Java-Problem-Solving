package main.test;

import main.java.Matrix;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @org.junit.jupiter.api.Test
    void rotate90right() {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix mat = new Matrix(input);
        mat.printMatrix();
        int[][] actual = mat.rotate90right();
        int[][] expected = {{7,4,1},{8,5,2},{9,6,3}};
        System.out.println(" ");
        mat.printMatrix();
        Assertions.assertTrue(Matrix.isEqualMatrix(expected, actual));
    }
}