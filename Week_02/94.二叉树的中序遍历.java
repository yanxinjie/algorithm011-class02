import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = root;
        while (nodeStack.size() > 0 || currentNode != null) {
            while(currentNode != null){
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = nodeStack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }
}
// @lc code=end

/**
 * 使用递归
 */
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        
        while (nodeStack.size() > 0 || root != null) {
            if (root.left != null) {
                nodeStack.add(root);
                root = root.left;
            } else {
                TreeNode currentNode = nodeStack.pop();
                result.add(currentNode.val);
                root = currentNode.right;
            }
        }

        return result;
    }
}