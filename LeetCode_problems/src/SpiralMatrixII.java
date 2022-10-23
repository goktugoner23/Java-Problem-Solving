import java.util.ArrayList;

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
    public int[][] generateMatrix(int n) {
        int[][] element = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                element[i][j] = j+1;
            }
        }
        return null;
    }
}
