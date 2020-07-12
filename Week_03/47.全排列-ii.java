import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (59.27%)
 * Likes:    343
 * Dislikes: 0
 * Total Accepted:    70K
 * Total Submissions: 118K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return ans;
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];

        _helper(nums, nums.length, 0, used, stack);

        return ans;
    }

    private void _helper(int[] nums,int len, int depth, boolean[] used, Stack<Integer> stack) {
        
        if (depth == len) {
            ans.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i ++) {
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;

            stack.push(nums[i]);
            used[i] = true;

            _helper(nums, len, depth + 1, used, stack);

            used[i] = false;
            stack.pop();
        }
    }
}
// @lc code=end

