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

    //    给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
    //
    //    例如，
    //
    //    给定二叉搜索树:
    //
    //            4
    //            / \
    //            2   7
    //            / \
    //            1   3
    //
    //    和值: 2
    //
    //    你应该返回如下子树:
    //
    //            2
    //            / \
    //            1   3
    //
    //    在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        insertIntoBSTItem(root, val);
        return root;
    }

    private static void insertIntoBSTItem(TreeNode root, int val) {
        if (root.val >= val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBSTItem(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBSTItem(root.right, val);
            }
        }
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        // 搜索匹配节点
        TreeNode delNodeParent = null;
        TreeNode treeNode = searchItem(root, key, delNodeParent);

        // 该节点只有一个叶子节点，则把此叶子节点替换成当前节点
        if(treeNode.left == null && treeNode.right == null){
            delNodeParent.
        }

        // 该节点由两个叶子节点，则找到右侧叶子节点的最深处左侧节点

        if(root.left == null && root.left == null){
            if(root.val == key){
                return null;
            } else {
                return root;
            }
        } else if(root.left != null && root.right == null){
            deleteNodeItem(root, root.left, key, 0);
        } else if(root.right != null && root.left == null){
            deleteNodeItem(root, root.right, key, 0);
        }

    }

    private static TreeNode searchItem(TreeNode node, int key, TreeNode parent){
        if(node == null){
            return null;
        }

        if(node.val == key){
            return node;
        }

        parent = node;
        if(node.val < key){
            return searchItem(node.right, key, parent);
        }

        if(node.val > key){
            return searchItem(node.left, key, parent);
        }
    }

    private static void deleteNodeItem(TreeNode parent, TreeNode node, int key, int target) {
        if (node.val > key) {
            deleteNodeItem(node, node.left, key, 0);
        } else if (node.val < key) {
            deleteNodeItem(node, node.right, key, 1);
        } else {
            // 没有子节点
            if (node.left == null && node.right == null) {
                if (target == 0) {
                    parent.left = null;
                }

                if (target == 1) {
                    parent.right = null;
                }
            }

            // 有一个子节点
            if (node.left != null && node.right == null) {
                if (target == 0) {
                    parent.left = node.left;
                }

                if (target == 1) {
                    parent.right = node.left;
                }
            }

            if (node.left == null && node.right != null) {
                if (target == 0) {
                    parent.left = node.right;
                }

                if (target == 1) {
                    parent.right = node.right;
                }
            }

            // 有两个子节点
            if (node.left != null && node.right != null) {
                TreeNode p = null;
                TreeNode minNode = searchLastLeftTreeNode(node.right, p);
            }
        }
    }

    private static TreeNode searchLastLeftTreeNode(TreeNode node, TreeNode parent) {
        if (node.left == null) {
            return node;
        } else {
            parent = node;
            return searchLastLeftTreeNode(node.left, parent);
        }
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
