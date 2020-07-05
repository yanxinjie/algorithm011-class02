/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (62.27%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    84.6K
 * Total Submissions: 135.8K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * 说明：
 * 
 * 
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

    }
}
// @lc code=end

/**
 * 使用HashMap
 */
class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;

        Map <String, List<String>> sortedStrToList = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] currentStrChar = strs[i].toCharArray();
            Arrays.sort(currentStrChar);
            String sortedStr = String.valueOf(currentStrChar);

            if (sortedStrToList.containsKey(sortedStr)) {
                List<String> tmp = sortedStrToList.get(sortedStr);
                tmp.add(strs[i]);
                sortedStrToList.put(sortedStr, tmp);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                sortedStrToList.put(sortedStr, tmp);
            }
        }
        for (List<String> strList: sortedStrToList.values()){
            result.add(strList);
        }
        return result;
    }
}