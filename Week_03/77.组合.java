import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (74.03%)
 * Likes:    309
 * Dislikes: 0
 * Total Accepted:    60.1K
 * Total Submissions: 81K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
    }
}
// @lc code=end

class Solution1 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return ans;
        }

        _helper(n, k, 1, new Stack<Integer>());
        return ans;
    }

    private void _helper(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size() == k) {
            ans.add(new ArrayList<>(pre));
            return;
        }

        for (int i = begin; i <= n; i ++) {
            pre.push(i);
            _helper(n, k, i + 1, pre);
            pre.pop();
        }

    }
}