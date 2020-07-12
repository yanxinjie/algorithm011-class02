import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import jdk.nashorn.internal.runtime.regexp.joni.Syntax;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (76.30%)
 * Likes:    783
 * Dislikes: 0
 * Total Accepted:    151.5K
 * Total Submissions: 198.4K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return ans;

        int len = nums.length;
        boolean[] isUsed = new boolean[len];
        Stack<Integer> stack = new Stack<>();
        
        _helper(nums, len, 0, isUsed, stack);

        return ans;
    }

    private void _helper(int[] nums, int len, int depth, boolean[] isUsed, Stack<Integer> stack) {
        if (depth == len) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i ++) {
            if (isUsed[i]) continue;

            stack.push(nums[i]);
            isUsed[i] = true;

            _helper(nums, len, depth + 1, isUsed, stack);

            isUsed[i] = false;
            stack.pop();
        }
    }
}
// @lc code=end

