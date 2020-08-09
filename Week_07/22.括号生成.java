import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (75.63%)
 * Likes:    1137
 * Dislikes: 0
 * Total Accepted:    143.2K
 * Total Submissions: 189.2K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3
 * 输出：[
 * ⁠      "((()))",
 * ⁠      "(()())",
 * ⁠      "(())()",
 * ⁠      "()(())",
 * ⁠      "()()()"
 * ⁠    ]
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return result;
        _generateHelper(0, 0, n, "");
        return result;
    }

    private void _generateHelper(int rightNum, int leftNum, int num, String ans) {
        if (rightNum == num && leftNum == num) {
            result.add(ans);
        }

        if (leftNum < num) _generateHelper(rightNum, leftNum + 1, num, ans + "(");
        if (rightNum < leftNum) _generateHelper(rightNum + 1, leftNum, num, ans + ")");
    }
}
// @lc code=end

