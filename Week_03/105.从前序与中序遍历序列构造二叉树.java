/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (67.34%)
 * Likes:    559
 * Dislikes: 0
 * Total Accepted:    93.5K
 * Total Submissions: 138.7K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

    private int[] inorder;
    private int[] preorder;
    private int preRootIndex;
    private Map<Integer, Integer> inorderValToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        preRootIndex = 0;

        for (int i = 0; i < inorder.length; i ++) {
            inorderValToIndex.put(inorder[i], i);
        }

        return helper(preRootIndex, preorder.length - 1);
    }

    private TreeNode helper (int left_index, int right_index) {
        if (left_index > right_index) return null;

        int rootVal = preorder[preRootIndex ++];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderValToIndex.get(rootVal);

        root.left = helper(left_index, index - 1);
        root.right = helper(index + 1, right_index);

        return root;
    }
}
// @lc code=end

