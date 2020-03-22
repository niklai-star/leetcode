package com.niklai.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TwoForkTreeTest {
    private TwoForkTree.TreeNode root;

    @BeforeEach
    public void before() {
        root = new TwoForkTree.TreeNode(3);
        TwoForkTree.TreeNode n9 = new TwoForkTree.TreeNode(9);
        TwoForkTree.TreeNode n20 = new TwoForkTree.TreeNode(20);
        TwoForkTree.TreeNode n15 = new TwoForkTree.TreeNode(15);
        TwoForkTree.TreeNode n7 = new TwoForkTree.TreeNode(7);

        n20.left = n15;
        n20.right = n7;
        root.left = n9;
        root.right = n20;
    }

    private TwoForkTree.TreeNode createTreeNode(Integer[] nums, int idx) {
        TwoForkTree.TreeNode n = null;
        if (idx < nums.length) {
            Integer num = nums[idx];
            if (num == null) {
                return null;
            }

            n = new TwoForkTree.TreeNode(num);
            n.left = createTreeNode(nums, 2 * idx + 1);
            n.right = createTreeNode(nums, 2 * idx + 2);
            return n;
        }
        return null;
    }

    @Test
    @DisplayName("二叉树前序遍历-递归")
    public void preorderTraversalTest() {
        List<Integer> list = TwoForkTree.preorderTraversal(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树前序遍历-迭代")
    public void preorderTraversal2Test() {
        List<Integer> list = TwoForkTree.preorderTraversal2(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树中序遍历-递归")
    public void inorderTraversalTest() {
        List<Integer> list = TwoForkTree.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树中序遍历-迭代")
    public void inorderTraversal2Test() {
        List<Integer> list = TwoForkTree.inorderTraversal2(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树后序遍历-递归")
    public void postorderTraversalTest() {
        List<Integer> list = TwoForkTree.postorderTraversal(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树后序遍历-迭代")
    public void postorderTraversal2Test() {
        List<Integer> list = TwoForkTree.postorderTraversal2(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树的层次遍历")
    public void levelOrderTest() {
        List<List<Integer>> list = TwoForkTree.levelOrder(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树的最大深度-递归（自底向上）")
    public void maxDepthTest() {
        int i = TwoForkTree.maxDepth(root);
        Assertions.assertEquals(i, 3);
    }

    @Test
    @DisplayName("二叉树的最大深度-迭代（自顶向下）")
    public void maxDepth2Test() {
        int i = TwoForkTree.maxDepth2(root);
        Assertions.assertEquals(i, 3);
    }

    @Test
    @DisplayName("对称二叉树-递归")
    public void isSymmetricTest() {
        TwoForkTree.TreeNode treeNode = createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 0);
        boolean result = TwoForkTree.isSymmetric(treeNode);
        Assertions.assertTrue(result);

        treeNode = createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3}, 0);
        result = TwoForkTree.isSymmetric(treeNode);
        Assertions.assertTrue(!result);
    }

    @Test
    @DisplayName("对称二叉树-迭代")
    public void isSymmetric2Test() {
        TwoForkTree.TreeNode treeNode = createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 0);
        boolean result = TwoForkTree.isSymmetric2(treeNode);
        Assertions.assertTrue(result);

        treeNode = createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3}, 0);
        result = TwoForkTree.isSymmetric2(treeNode);
        Assertions.assertTrue(!result);
    }

    private TwoForkTree.TreeNode hasPathSumNode() {
        TwoForkTree.TreeNode root = new TwoForkTree.TreeNode(5);
        TwoForkTree.TreeNode n4 = new TwoForkTree.TreeNode(4);
        TwoForkTree.TreeNode n8 = new TwoForkTree.TreeNode(8);
        TwoForkTree.TreeNode n11 = new TwoForkTree.TreeNode(11);
        TwoForkTree.TreeNode n13 = new TwoForkTree.TreeNode(13);
        TwoForkTree.TreeNode n44 = new TwoForkTree.TreeNode(4);
        TwoForkTree.TreeNode n7 = new TwoForkTree.TreeNode(7);
        TwoForkTree.TreeNode n2 = new TwoForkTree.TreeNode(2);
        TwoForkTree.TreeNode n1 = new TwoForkTree.TreeNode(1);

        n11.left = n7;
        n11.right = n2;
        n44.right = n1;
        n4.left = n11;
        n8.left = n13;
        n8.right = n44;
        root.left = n4;
        root.right = n8;
        return root;
    }

    @Test
    @DisplayName("路径总和-递归")
    public void hasPathSumTest() {
        TwoForkTree.TreeNode root = hasPathSumNode();

        boolean result = TwoForkTree.hasPathSum(root, 22);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("路径总和-迭代")
    public void hasPathSum2Test() {
        TwoForkTree.TreeNode root = hasPathSumNode();

        boolean result = TwoForkTree.hasPathSum2(root, 22);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("从前序与中序遍历序列构造二叉树-递归")
    public void buildTreeTest() {
        TwoForkTree.TreeNode treeNode = TwoForkTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    @Test
    @DisplayName("从中序与后序遍历序列构造二叉树-递归")
    public void buildTree2Test() {
        TwoForkTree.TreeNode treeNode = TwoForkTree.buildTree2(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
