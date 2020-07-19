import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 *
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/description/
 *
 * algorithms
 * Medium (50.75%)
 * Likes:    42
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 11.9K
 * Testcase Example:  '"AACCGGTT"\n"AACCGGTA"\n["AACCGGTA"]'
 *
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 
 * 现在给定3个参数 — start, end,
 * bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回
 * -1。
 * 
 * 注意:
 * 
 * 
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * 
 * 
 * 示例 1:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * 
 * 返回值: 1
 * 
 * 
 * 示例 2:
 * 
 * 
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * 
 * 返回值: 2
 * 
 * 
 * 示例 3:
 * 
 * 
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * 
 * 返回值: 3
 * 
 * 
 */

// @lc code=start
/**
 * DFS
 */
class Solution {
    private HashSet<String> bankSet;
    private HashSet<String> visited = new HashSet<>();
    private char[] banks = {'A', 'C', 'G', 'T'};
    private int minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        _dfsHelper(start, end, 0);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void _dfsHelper(String start, String end, int step) {
        if (start.equals(end)) {
            minStep = Math.min(step, minStep);
            return;
        }
        visited.add(start);
        bankSet.remove(start);
        char[] curChars = start.toCharArray();
        for (int i = 0; i < curChars.length; i ++) {
            char old = curChars[i];
            for (char bank : banks) {
                curChars[i] = bank;
                String newStart = String.valueOf(curChars);
                if (bankSet.contains(newStart)) _dfsHelper(newStart, end, step + 1);
            }
            curChars[i] = old;
        }

    }
}
// @lc code=end
/**
 * BFS
 */
class Solution1 {
    public int minMutation(String start, String end, String[] bank) {
        return _bfsHelper(start, end, bank);
    }


    private int _bfsHelper(String start, String end, String[] bank) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] banks = {'A', 'C', 'G', 'T'};
        Deque<String> deque = new LinkedList<>();
        deque.offer(start);
        int count = 0;
        
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            while (dequeSize -- > 0) {
                String curString = deque.poll();
                if (curString.equals(end)) return count;
                char[] curChars = curString.toCharArray();
                
                for (int i = 0; i < curChars.length; i ++) {
                    char old = curChars[i];
                    for (char b : banks) {
                        curChars[i] = b;
                        String newString = String.valueOf(curChars);
                        if (!visited.contains(newString) && bankSet.contains(newString)) {
                            visited.add(newString);
                            deque.offer(newString);
                        }
                    }
                    curChars[i] = old;
                }
            }
            count ++;
        }
        return -1;
    }
}