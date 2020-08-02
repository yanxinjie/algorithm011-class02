/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (65.86%)
 * Likes:    607
 * Dislikes: 0
 * Total Accepted:    130.2K
 * Total Submissions: 193.1K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] tmpArr = grid;
        int m = tmpArr[0].length, n = tmpArr.length;
        for (int i = 1; i < n; i ++) tmpArr[i][0] += tmpArr[i - 1][0];
        for (int i = 1; i < m; i ++) tmpArr[0][i] += tmpArr[0][i - 1];

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                tmpArr[i][j] += Math.min(tmpArr[i-1][j], tmpArr[i][j-1]);
            }
        }
        return tmpArr[n - 1][m - 1];
    }
}
// @lc code=end

