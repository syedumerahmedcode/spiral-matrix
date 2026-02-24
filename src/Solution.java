import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int visited = 10001;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0, column = 0;
        //directions:::right, down, left, up
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        int currentDirection = 0, changedDirection = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        matrix[0][0] = visited;
        //Why 2? right+down OR left+up
        while (changedDirection < 2) {
             while(row + directions[currentDirection][0] >= 0 &&
                    row + directions[currentDirection][0] < rows &&
                    column + directions[currentDirection][1] >= 0 && 
                    column + directions[currentDirection][1] < columns &&
                    matrix[row+directions[currentDirection][0]][column + directions[currentDirection][1]] != visited){

                changedDirection = 0;
                row = row + directions[currentDirection][0];
                column = column + directions[currentDirection][1];

                ans.add(matrix[row][column]);
                matrix[row][column] = visited;
            }
            currentDirection = (currentDirection + 1) % 4;
            changedDirection++;
        }
        return ans;
        
    }

}
