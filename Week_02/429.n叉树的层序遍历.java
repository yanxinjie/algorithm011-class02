import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;

import sun.misc.Queue;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (65.70%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    23.4K
 * Total Submissions: 35.6K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * 以不同的顺序添加到最终列表中，只要我们知道节点在哪一层并确保在那一层的列表顺序正确就可以了。
 */
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return result;
        return helper(root, 0);
    } 

    private List<List<Integer>> helper(Node node, int level) {
        //提前创建好lervel层的数据
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        for (Node n: node.children) {
            helper(n, level + 1);
        }
        return result;
    }
}
// @lc code=end

/**
 * 利用队列实现广度优先搜索
 * 每层遍历所有Node，存储vals,并存储好下一层的children
 */
class Solution1 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (nodeQueue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i ++) {
                Node treeNode = nodeQueue.poll();
                level.add(treeNode.val);
                nodeQueue.addAll(treeNode.children);
            }
            result.add(level);
        }

        return result;
    }
    
}

/**
 * 简化的广度优先搜索
 */
class Solution2 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Node> previousLayer = new ArrayList<>();
        previousLayer.add(root);

        while (previousLayer.size() > 0) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> currentLayerResult = new ArrayList<>();
            for (Node node: previousLayer) {
                currentLayerResult.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(currentLayerResult);
            previousLayer = currentLayer;
        }
        return result;
    } 
}