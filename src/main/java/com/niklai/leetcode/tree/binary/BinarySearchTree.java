package com.niklai.leetcode.tree.binary;

import java.util.*;

public class BinarySearchTree {

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
        if (treeNode.left == null && treeNode.right == null) {

        }

        // 该节点由两个叶子节点，则找到右侧叶子节点的最深处左侧节点

        if (root.left == null && root.left == null) {
            if (root.val == key) {
                return null;
            } else {
                return root;
            }
        } else if (root.left != null && root.right == null) {
            deleteNodeItem(root, root.left, key, 0);
        } else if (root.right != null && root.left == null) {
            deleteNodeItem(root, root.right, key, 0);
        }

        return null;
    }

    private static TreeNode searchItem(TreeNode node, int key, TreeNode parent) {
        if (node == null) {
            return null;
        }

        if (node.val == key) {
            return node;
        }

        parent = node;
        if (node.val < key) {
            return searchItem(node.right, key, parent);
        }

        if (node.val > key) {
            return searchItem(node.left, key, parent);
        }

        return null;
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

    //    给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
    //
    //    示例 1:
    //
    //    输入: nums = [1,2,3,1], k = 3, t = 0
    //    输出: true
    //
    //    示例 2:
    //
    //    输入: nums = [1,0,1,1], k = 1, t = 2
    //    输出: true
    //
    //    示例 3:
    //
    //    输入: nums = [1,5,9,1,5,9], k = 2, t = 3
    //    输出: false
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                set.remove((long) nums[i - k - 1]);
            }

            if (t == 0) {
                if (set.contains((long) nums[i])) {
                    return true;
                }
            } else {
                for (Long num : set) {
                    if (Math.abs((long) nums[i] - num) <= t) {
                        return true;
                    }
                }
            }

            set.add((long) nums[i]);
        }

        return false;
    }

    //    给定一个二叉树，判断它是否是高度平衡的二叉树。
    //
    //    本题中，一棵高度平衡二叉树定义为：
    //
    //    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    //
    //    示例 1:
    //
    //    给定二叉树 [3,9,20,null,null,15,7]
    //
    //            3
    //           / \
    //          9  20
    //            /  \
    //           15   7
    //
    //    返回 true 。
    //
    //    示例 2:
    //
    //    给定二叉树 [1,2,2,3,3,null,null,4,4]
    //
    //            1
    //           / \
    //          2   2
    //         / \
    //        3   3
    //       / \
    //      4   4
    //
    //    返回 false 。
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getMaxHeight(root.left) - getMaxHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getMaxHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getMaxHeight(node.left);
        int rightHeight = getMaxHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //    将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
    //
    //    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
    //
    //    示例:
    //
    //    给定有序数组: [-10,-3,0,5,9],
    //
    //    一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
    //
    //            0
    //           / \
    //         -3   9
    //         /   /
    //       -10  5
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTItem(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTItem(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTItem(nums, start, mid - 1);
        node.right = sortedArrayToBSTItem(nums, mid + 1, end);
        return node;
    }

    //    实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
    //
    //    调用 next() 将返回二叉搜索树中的下一个最小的数。
    //
    //
    //
    //    示例：
    //
    //    BSTIterator iterator = new BSTIterator(root);
    //    iterator.next();    // 返回 3
    //    iterator.next();    // 返回 7
    //    iterator.hasNext(); // 返回 true
    //    iterator.next();    // 返回 9
    //    iterator.hasNext(); // 返回 true
    //    iterator.next();    // 返回 15
    //    iterator.hasNext(); // 返回 true
    //    iterator.next();    // 返回 20
    //    iterator.hasNext(); // 返回 false
    //
    //
    //
    //    提示：
    //
    //    next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
    //    你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
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
