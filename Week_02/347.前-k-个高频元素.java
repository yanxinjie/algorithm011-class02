import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import javax.swing.plaf.nimbus.NimbusStyle;

import org.omg.CORBA.Current;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (60.65%)
 * Likes:    384
 * Dislikes: 0
 * Total Accepted:    63K
 * Total Submissions: 103.8K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= k) return nums;
        HashMap<Integer, Integer> numToTimes = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i ++) {
            if (numToTimes.containsKey(nums[i])) {
                int curTime = numToTimes.get(nums[i]) + 1;
                numToTimes.put(nums[i], curTime);
            } else {
                numToTimes.put(nums[i], 1);
            }
        }

        // 优先队列
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b) {
                    return numToTimes.get(a) - numToTimes.get(b);
                }
            });
        for (Integer key: numToTimes.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (numToTimes.get(key) > numToTimes.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }

        for (int i = 0; i < result.length; i ++) {
            result[i] = heap.remove();
        }
        return result;
    }
}
// @lc code=end

