import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 *
 * https://leetcode-cn.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (52.63%)
 * Likes:    318
 * Dislikes: 0
 * Total Accepted:    28.3K
 * Total Submissions: 53.7K
 * Testcase Example:  '10'
 *
 * 编写一个程序，找出第 n 个丑数。
 * 
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 * 
 * 示例:
 * 
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 
 * 说明:  
 * 
 * 
 * 1 是丑数。
 * n 不超过1690。
 * 
 * 
 */

// @lc code=start
class Ugly3 {
    static int[] uglyNums = new int[1690];
    public Ugly3() {
        uglyNums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1 ; i < uglyNums.length; i ++) {
            uglyNums[i] = Math.min(Math.min(uglyNums[i2] * 2, uglyNums[i3] * 3), uglyNums[i5] * 5);

            if (uglyNums[i] == uglyNums[i2] * 2) i2++;
            if (uglyNums[i] == uglyNums[i3] * 3) i3++;
            if (uglyNums[i] == uglyNums[i5] * 5) i5++;
        }
    }
}
class Solution {
    static Ugly3 ugly = new Ugly3();
    public int nthUglyNumber(int n) {
        return ugly.uglyNums[n - 1];
    }
}
// @lc code=end
/**
 * 該方法超時
 */
class Solution1 {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        Stack<Integer> tmpStack = new Stack<>();
        int i = 1;
        tmpStack.push(1);
        while (tmpStack.size() < n) {
            int tmp = i + 1;
            while (tmp != 1) {
                if(tmp % 2 == 0) tmp /= 2;
                else if(tmp % 3 == 0) tmp /= 3;
                else if(tmp % 5 == 0) tmp /= 5;
                else break;
            }
            if (tmp == 1) {
                tmpStack.push((i + 1));
            }
            i++;
        }
        return tmpStack.pop();
    }
}

class Ugly2 {
    static int[] uglyNums = new int[1690];

    public Ugly(){
        prepareUglyNums();
    }

    static void prepareUglyNums() {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        priorityQueue.add(1L);
        seen.add(1L);
        
        Long currentUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < 1690; i ++) {
            currentUgly = priorityQueue.poll();
            uglyNums[i] = currentUgly.intValue();
            for (int j = 0; j < primes.length; j ++) {
                newUgly = currentUgly * primes[j];
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    priorityQueue.add(newUgly);
                }
            }
        }

    }
}

class Solution2 {
    static Ugly2 ugly = new Ugly2();
    public int nthUglyNumber(int n) {
        return ugly.uglyNums[n - 1];
    }
}