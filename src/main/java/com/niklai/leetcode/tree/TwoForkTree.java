package com.niklai.leetcode.tree;

import java.util.*;

public class TwoForkTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 给定一个二叉树，返回它的 前序 遍历。
    //
    // 示例:
    //
    // 输入: [1,null,2,3]
    //        1
    //         \
    //          2
    //          /
    //         3
    //
    // 输出: [1,2,3]
    //
    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        list.add(root.val);
        // 递归
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode n = st.pop();
            list.add(n.val);

            if (n.right != null) {
                st.push(n.right);
            }

            if (n.left != null) {
                st.push(n.left);
            }
        }

        return list;
    }

    // 给定一个二叉树，返回它的 中序 遍历。
    //
    // 示例:
    //
    // 输入: [1,null,2,3]
    //        1
    //         \
    //          2
    //          /
    //         3
    //
    // 输出: [1,3,2]
    //
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        // 递归
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    public static List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode n = root;
        do {
            while (n != null) {
                st.push(n);
                n = n.left;
            }

            if (!st.isEmpty()) {
                n = st.pop();
                list.add(n.val);
                n = n.right;
            }
        } while (!st.isEmpty() || n != null);
        return list;
    }

    // 给定一个二叉树，返回它的 后序 遍历。
    //
    // 示例:
    //
    // 输入: [1,null,2,3]
    //        1
    //         \
    //          2
    //          /
    //         3
    //
    // 输出: [3,2,1]
    //
    public static List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        // 递归
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        //
        while (!st.isEmpty()) {
            TreeNode n = st.pop();

            if (n.left != null) {
                st.push(n.left);
            }

            if (n.right != null) {
                st.push(n.right);
            }

            list.add(0, n.val);
        }

        return list;
    }

    //    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    //
    //    例如:
    //    给定二叉树: [3,9,20,null,null,15,7],
    //
    //             3
    //            / \
    //           9  20
    //             /  \
    //            15   7
    //
    //    返回其层次遍历结果：
    //
    //            [
    //              [3],
    //              [9,20],
    //              [15,7]
    //            ]
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode n = queue.poll();
                item.add(n.val);

                if (n.left != null) {
                    queue.offer(n.left);
                }

                if (n.right != null) {
                    queue.offer(n.right);
                }

                size--;
            }

            list.add(item);
        }

        return list;
    }

    //    给定一个二叉树，找出其最大深度。
    //
    //    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //
    //    说明: 叶子节点是指没有子节点的节点。
    //
    //    示例：
    //    给定二叉树 [3,9,20,null,null,15,7]，
    //
    //            3
    //           / \
    //          9  20
    //            /  \
    //           15   7
    //
    //    返回它的最大深度 3 。
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Object[]> st = new Stack<>();
        st.add(new Object[]{root, 1});

        int dept = 0;
        while (!st.isEmpty()) {
            Object[] item = st.pop();
            TreeNode n = (TreeNode) item[0];
            Integer currentDept = (Integer) item[1];

            dept = Math.max(dept, currentDept);
            if (n.right != null) {
                st.push(new Object[]{n.right, currentDept + 1});
            }

            if (n.left != null) {
                st.push(new Object[]{n.left, currentDept + 1});
            }
        }

        return dept;
    }

    //    给定一个二叉树，检查它是否是镜像对称的。
    //
    //    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //
    //            1
    //            / \
    //            2   2
    //            / \ / \
    //            3  4 4  3
    //
    //    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //            1
    //            / \
    //            2   2
    //            \   \
    //            3    3
    //
    //    说明:
    //
    //    如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricItem(root.left, root.right);
    }

    private static boolean isSymmetricItem(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }

        if (right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricItem(left.left, right.right) && isSymmetricItem(left.right, right.left);
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);

        while (!st.isEmpty()) {
            TreeNode r = st.pop();
            TreeNode l = st.pop();

            if (l == null && r == null) {
                continue;
            } else if (l != null && r == null || l == null && r != null) {
                return false;
            } else if (l.val != r.val) {
                return false;
            } else {
                st.push(l.left);
                st.push(r.right);

                st.push(r.left);
                st.push(l.right);
            }
        }

        return true;
    }

    //    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    //
    //    说明: 叶子节点是指没有子节点的节点。
    //
    //    示例:
    //    给定如下二叉树，以及目标和 sum = 22，
    //
    //            5
    //           / \
    //          4   8
    //         /   / \
    //        11  13  4
    //       /  \      \
    //      7    2      1
    //
    //    返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
    public static boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSumItem(root, 0, sum) || hasPathSumItem(root, 0, sum);
    }

    private static boolean hasPathSumItem(TreeNode node, int upResult, int sum) {
        if (node == null) {
            return false;
        }

        int result = node.val + upResult;
        if (node.left == null && node.right == null) {
            return sum == result;
        }

        return hasPathSumItem(node.left, result, sum) || hasPathSumItem(node.right, result, sum);
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> sNode = new Stack<>();
        Stack<Integer> sSum = new Stack<>();
        sNode.push(root);
        sSum.push(root.val);

        while (!sNode.isEmpty()) {
            TreeNode node = sNode.pop();
            Integer n = sSum.pop();
            if (node.left == null && node.right == null) {
                if (n == sum) {
                    return true;
                }
            }

            if (node.right != null) {
                sNode.push(node.right);
                sSum.push(n + node.right.val);
            }

            if (node.left != null) {
                sNode.push(node.left);
                sSum.push(n + node.left.val);
            }
        }

        return false;
    }

    //    根据一棵树的前序遍历与中序遍历构造二叉树。
    //
    //    注意:
    //    你可以假设树中没有重复的元素。
    //
    //    例如，给出
    //
    //    前序遍历 preorder = [3,9,20,15,7]
    //    中序遍历 inorder = [9,3,15,20,7]
    //
    //    返回如下的二叉树：
    //
    //            3
    //           / \
    //          9  20
    //            /  \
    //           15   7
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 根据前序获取根节点
        TreeNode root = new TreeNode(preorder[0]);
        List<Integer> inOrderList = new ArrayList<>();
        for (int n : inorder) {
            inOrderList.add(n);
        }

        buildTreeItem(preorder, 0, inOrderList, root);
        return root;
    }

    private static void buildTreeItem(int[] preorder, int n, List<Integer> inorderList, TreeNode root) {
        // 根据前序的根节点分隔中序，根节点左边都在树的左侧，右边都在树的右侧
        List<Integer> leftInOrderList = inorderList.subList(0, inorderList.indexOf(root.val));
        for (int i = n + 1; i < preorder.length; i++) {
            int rootNum = preorder[i];
            if (leftInOrderList.contains(rootNum)) {
                root.left = new TreeNode(rootNum);

                // 当前节点作为下级的根节点，分割出来的左边数组作为当前节点的中序，递归
                buildTreeItem(preorder, i, leftInOrderList, root.left);
                break;
            }
        }

        List<Integer> rightInOrderList = inorderList.subList(inorderList.indexOf(root.val) + 1, inorderList.size());
        for (int j = n + 1; j < preorder.length; j++) {
            int rootNum = preorder[j];
            if (rightInOrderList.contains(rootNum)) {
                root.right = new TreeNode(rootNum);

                // 当前节点作为下级的根节点，分割出来的右边数组作为当前节点的中序，递归
                buildTreeItem(preorder, j, rightInOrderList, root.right);
                break;
            }
        }
    }

    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }

        // 根据后序获取根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        List<Integer> inOrderList = new ArrayList<>();
        for (int n : inorder) {
            inOrderList.add(n);
        }

        buildTree2Item(inOrderList, postorder, postorder.length - 1, root);
        return root;
    }

    private static void buildTree2Item(List<Integer> inorderList, int[] postorder, int n, TreeNode root) {
        // 根据后序的根节点分隔中序，根节点左边都在树的左侧，右边都在树的右侧
        List<Integer> rightInOrderList = inorderList.subList(inorderList.indexOf(root.val) + 1, inorderList.size());
        for (int j = n - 1; j >= 0; j--) {
            int rootNum = postorder[j];
            if (rightInOrderList.contains(rootNum)) {
                root.right = new TreeNode(rootNum);

                // 当前节点作为下级的根节点，分割出来的右边数组作为当前节点的中序，递归
                buildTree2Item(rightInOrderList, postorder, j, root.right);
                break;
            }
        }

        List<Integer> leftInOrderList = inorderList.subList(0, inorderList.indexOf(root.val));
        for (int i = n - 1; i >= 0; i--) {
            int rootNum = postorder[i];
            if (leftInOrderList.contains(rootNum)) {
                root.left = new TreeNode(rootNum);

                // 当前节点作为下级的根节点，分割出来的左边数组作为当前节点的中序，递归
                buildTree2Item(leftInOrderList, postorder, i, root.left);
                break;
            }
        }
    }
}
