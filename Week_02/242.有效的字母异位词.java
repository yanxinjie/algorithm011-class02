import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (60.37%)
 * Likes:    209
 * Dislikes: 0
 * Total Accepted:    112.4K
 * Total Submissions: 186.1K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        // sort
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < sChars.length; i ++) {
            if (sChars[i] != tChars[i]) return false;
        }
        
        return true;
    }
}
// @lc code=end

class Solutio1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> charToNum = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        for (int i = 0; i < sChars.length; i ++) {
            charToNum.put(sChars[i], charToNum.containsKey(sChars[i]) ? charToNum.get(sChars[i]) + 1: 1);
        }

        for (int i = 0; i < tChars.length; i ++) {
            if (!charToNum.containsKey(tChars[i])) return false;
            int currentNum = charToNum.get(tChars[i]) - 1;
            if (currentNum < 0) return false;
            charToNum.put(tChars[i], currentNum);
        }
        return true;
    }
}