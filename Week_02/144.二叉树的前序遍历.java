import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (65.94%)
 * Likes:    297
 * Dislikes: 0
 * Total Accepted:    125.4K
 * Total Submissions: 190.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !nodeStack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                nodeStack.push(cur);
                cur = cur.left;
            }
            cur = nodeStack.pop();
            cur = cur.right;
        }
        return result;
    }
}
// @lc code=end
/**
 * 递归
 */
class Solution1 {

    private List<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        return result;

    }

    private void helper(TreeNode node) {
        if (node == null) return;
        result.add(node.val);
        if (node.left != null) helper(node.left);
        if (node.right != null) helper(node.right);
    }
}