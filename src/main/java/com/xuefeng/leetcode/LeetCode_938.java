package com.xuefeng.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_938 {

    /**
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     *
     * 二叉搜索树的性质：
     *      当前节点的左子树的所有节点都不大于当前节点，
     *      当前节点的右子树的所有节点都不小于当前节点。
     *
     *
     *
     * 示例 1：层序
     *  10, 5, 15, 3, 7, null, 18
     *
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     *
     *
     * 示例 2：层序
     *  10, 5, 15, 3, 7, 13, 18, 1, null, 6
     *
     *
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * 输出：23
     *  
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 2 * 104] 内
     * 1 <= Node.val <= 105
     * 1 <= low <= high <= 105
     * 所有 Node.val 互不相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 递归
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
             return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left,low, high) + rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left,low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 先序遍历
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST_preOrder(TreeNode root, int low, int high) {
        int sum = 0;

        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum = sum + root.val;
            }
            sum = sum + rangeSumBST_preOrder(root.left, low, high);
            sum = sum + rangeSumBST_preOrder(root.right, low, high);
        }

        return sum;
    }

    /**
     * 按 二叉搜索树 的性质优化先序遍历
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST_preOrder2(TreeNode root, int low, int high) {
        int sum = 0;

        if (root != null) {
            if (root.val >= low && root.val <= high) {
                sum = sum + root.val;
                sum = sum +rangeSumBST_preOrder2(root.right, low, high);
                sum = sum + rangeSumBST_preOrder2(root.left, low, high);
            }
            if (root.val < low) sum = sum + rangeSumBST_preOrder2(root.right, low, high);
            if (root.val > high) sum = sum + rangeSumBST_preOrder2(root.left, low, high);

        }

        return sum;
    }
    /**
     * 后序遍历
     */
    public int rangeSumBST_lastOrder(TreeNode root, int low, int high) {
        int sum = 0;

        if (root != null) {
            sum = sum + rangeSumBST_lastOrder(root.left, low, high);
            sum = sum + rangeSumBST_lastOrder(root.right, low, high);
            if (root.val >= low && root.val <= high) {
                sum = sum + root.val;
            }
        }

        return sum;

    }

    /**
     * 中序遍历
     */
    public int rangeSumBST_midOrder(TreeNode root, int low, int high) {
        int sum = 0;

        if (root != null) {
            sum = sum + rangeSumBST_midOrder(root.left, low, high);
            if (root.val >= low && root.val <= high) {
                sum = sum + root.val;
            }
            sum = sum + rangeSumBST_midOrder(root.right, low, high);
        }

        return sum;

    }

    /**
     * 层序遍历
     */
    public int rangeSumBST_levelOrder(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (root.val >= low && root.val <= high) {
                    sum = sum + root.val;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return sum;
    }

}
