package com.niklai.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoForkSearchTree {

    //    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    //
    //    假设一个二叉搜索树具有如下特征：
    //
    //    节点的左子树只包含小于当前节点的数。
    //    节点的右子树只包含大于当前节点的数。
    //    所有左子树和右子树自身必须也是二叉搜索树。
    //
    //    示例 1:
    //
    //    输入:
    //            2
    //           / \
    //          1   3
    //    输出: true
    //
    //    示例 2:
    //
    //    输入:
    //            5
    //           / \
    //          1   4
    //             / \
    //            3   6
    //    输出: false
    //    解释: 输入为: [5,1,4,null,null,3,6]。
    //    根节点的值为 5 ，但是其右子节点值为 4 。
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBSTItem(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBSTItem(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }

        return isValidBSTItem(node.left, min, node.val) && isValidBSTItem(node.right, node.val, max);
    }

    public static class BSTIterator {
        private List<Integer> list = new ArrayList<>();
        private int i = 0;

        public BSTIterator(TreeNode root) {
            if (root == null) {
                return;
            }

            Stack<TreeNode> st = new Stack<>();
            TreeNode n = root;
            do {
                while (n != null) {
                    st.push(n);
                    n = n.left;
                }

                if (!st.isEmpty()) {
                    TreeNode tmp = st.pop();
                    list.add(tmp.val);
                    n = tmp.right;
                }

            } while (!st.isEmpty() || n != null);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            Integer num = list.get(i);
            i++;
            return num;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return i < list.size();
        }
    }
}
