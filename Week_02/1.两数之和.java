import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (48.87%)
 * Likes:    8550
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 2.4M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            int value = target - nums[i];
            if (!valueToIndex.containsKey(value)) {
                valueToIndex.put(nums[i], i);
            } else {
                result[0] = valueToIndex.get(value);
                result[1] = i;
                return result;
            }
        }
        return result;
    }
}
// @lc code=end

