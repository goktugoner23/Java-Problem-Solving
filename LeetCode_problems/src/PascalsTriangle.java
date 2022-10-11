/*https://leetcode.com/problems/pascals-triangle/
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]
Constraints:
1 <= numRows <= 30*/

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new LinkedList<>(); //will be returned
        List<Integer> row1 = new LinkedList<>();
        row1.add(1);
        mainList.add(row1);
        if (numRows == 1){
            return mainList;
        }
        List<Integer> row2 = new LinkedList<>();
        row2.add(1);
        row2.add(1);
        mainList.add(row2);
        if(numRows == 2){
            return mainList;
        }
        for(int i = 1; i < numRows - 1; i ++){
            List<Integer> row = new LinkedList<>();
            row.add(1);
            for(int j = 0; j < mainList.get(i).size() - 1; j++){
                int sum = 0;
                sum += mainList.get(i).get(j) + mainList.get(i).get(j+1);
                row.add(sum);
            }
            row.add(1);
            mainList.add(row);
        }
        return mainList;
    }
}
