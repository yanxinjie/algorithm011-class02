import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (49.67%)
 * Likes:    659
 * Dislikes: 0
 * Total Accepted:    129.5K
 * Total Submissions: 260.2K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 
 */

// @lc code=start
class Solution {

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count ++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i * cols + j);
                    marked[i][j] = true;
                    // 标记相邻的岛屿
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int curX = cur / cols;
                        int curY = cur % cols;

                        for (int k = 0; k < 4; k ++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];

                            if (inArea(newX, newY) && !marked[newX][newY] && grid[newX][newY] == '1') {
                                queue.offer(newX *cols + newY);
                                marked[newX][newY] = true;
                            }
                        }
                    }

                }
            }
        }

        return count;
    }

    private boolean inArea(int x, int y) {
        // 等于号这些细节不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
// @lc code=end

