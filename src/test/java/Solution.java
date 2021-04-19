import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tao
 * @date 2021/4/13 10:13 上午
 */
public class Solution {

    public static int maximalSquare(char[][] matrix) {
        // 枚举顶点和边长

        int rows = matrix.length;
        int cols = matrix[0].length;


        // 建立两个辅助数组，记录右侧，下侧连续最长的1
        int[][] rightHelp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            rightHelp[row][cols - 1] = matrix[row][cols - 1] == '1' ? 1 : 0;
        }
        for (int col = cols - 2; col >= 0; col--) {
            for (int row = rows - 1; row >= 0; row--) {
                rightHelp[row][col] = matrix[row][col] == '1' ? rightHelp[row][col + 1] + 1 : 0;
            }
        }

        int maxLength = Math.min(rows, cols);

        int ans = 0;
        for (int i = 1; i <= maxLength; i++) {
            for (int row = 0; row <= rows - i; row++) {
                for (int col = 0; col <= cols - i; col++) {
                    boolean flag = true;
                    for (int tmp = row; tmp <= row + i -1; tmp++) {
                        if (rightHelp[tmp][col] < i) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ans = Math.max(ans, i * i);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));

        matrix = new char[][] {{'0', '1'}, {'1', '0'}};
        System.out.println(maximalSquare(matrix));

        matrix = new char[][] {{'0'}};
        System.out.println(maximalSquare(matrix));

        //[["1","0","1","1","0","1"],["1","1","1","1","1","1"],["0","1","1","0","1","1"],["1","1","1","0","1","0"],["0","1","1","1","1","1"],["1","1","0","1","1","1"]]
        matrix = new char[][] {
                {'1', '0', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '1'}
        };
        System.out.println(maximalSquare(matrix));
    }
}
