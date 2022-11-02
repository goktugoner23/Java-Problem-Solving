package main.java;

/*https://leetcode.com/problems/spiral-matrix-ii/
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20*/
public class SpiralMatrixII {
    enum Direction {
        RIGHT,
        LEFT,
        UP,
        DOWN;

        public static Direction initialize() {
            return RIGHT;
        }

        public static Direction next(Direction currentDir) {
            switch (currentDir) {
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case UP:
                    return RIGHT;
                default:
                    throw new NullPointerException();
            }
        }
    }

    private static int[][] generateMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        else if(n == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        Direction direction = Direction.initialize();
        int i = 0;
        int j = 0;
        for(int k = 1; k <= n*n; k++){
            matrix[i][j] = k;
            if(direction == Direction.RIGHT){
                if(isEndOfRight(matrix, i, j)){
                    direction = Direction.next(direction);
                    i++; //for the last step
                }
                else{
                    j++;
                }
            }
            else if(direction == Direction.DOWN){
                if(isEndOfDown(matrix, i, j)){
                    direction = Direction.next(direction);
                    j--;
                }
                else{
                    i++;
                }
            }
            else if(direction == Direction.LEFT){
                if(isEndOfLeft(matrix, i, j)){
                    direction = Direction.next(direction);
                    i--;
                }
                else{
                    j--;
                }
            }
            else if(direction == Direction.UP){
                if(isEndOfUp(matrix, i, j)){
                    direction = Direction.next(direction);
                    j++;
                }
                else{
                    i--;
                }
            }
        }
        return matrix;
    }

    private static boolean isEndOfRight(int[][] matrix, int i, int j){
        int columnSize = matrix.length;
        return j + 1 == columnSize || matrix[i][j+1] != 0;
    }
    private static boolean isEndOfLeft(int[][] matrix, int i, int j){
        return j == 0 || matrix[i][j-1] != 0;
    }
    private static boolean isEndOfUp(int[][] matrix, int i, int j){
        return i == 0 || matrix[i - 1][j] != 0;
    }
    private static boolean isEndOfDown(int[][] matrix, int i, int j){
        int rowSize = matrix.length;
        return i + 1 == rowSize || matrix[i + 1][j] != 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(6);
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
                System.out.println(" ");
        }
            // Loop through all elements of current row for printing
    }

}
