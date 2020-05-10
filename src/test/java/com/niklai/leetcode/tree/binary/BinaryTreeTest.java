package com.niklai.leetcode.tree.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreeTest {
    private TreeNode root;

    @BeforeEach
    public void before() {
        root = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);

        n20.left = n15;
        n20.right = n7;
        root.left = n9;
        root.right = n20;
    }

    private TreeNode createTreeNode(Integer[] nums, int idx) {
        TreeNode n = null;
        if (idx < nums.length) {
            Integer num = nums[idx];
            if (num == null) {
                return null;
            }

            n = new TreeNode(num);
            n.left = createTreeNode(nums, 2 * idx + 1);
            n.right = createTreeNode(nums, 2 * idx + 2);
            return n;
        }
        return null;
    }

    private Node createNode(Integer[] nums, int idx) {
        Node n = null;
        if (idx < nums.length) {
            Integer num = nums[idx];
            if (num == null) {
                return null;
            }

            n = new Node(num);
            n.left = createNode(nums, 2 * idx + 1);
            n.right = createNode(nums, 2 * idx + 2);
            return n;
        }
        return null;
    }

    @Test
    @DisplayName("二叉树前序遍历-递归")
    public void preorderTraversalTest() {
        List<Integer> list = BinaryTree.preorderTraversal(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树前序遍历-迭代")
    public void preorderTraversal2Test() {
        List<Integer> list = BinaryTree.preorderTraversal2(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树中序遍历-递归")
    public void inorderTraversalTest() {
        List<Integer> list = BinaryTree.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树中序遍历-迭代")
    public void inorderTraversal2Test() {
        List<Integer> list = BinaryTree.inorderTraversal2(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树后序遍历-递归")
    public void postorderTraversalTest() {
        List<Integer> list = BinaryTree.postorderTraversal(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树后序遍历-迭代")
    public void postorderTraversal2Test() {
        List<Integer> list = BinaryTree.postorderTraversal2(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树的层次遍历")
    public void levelOrderTest() {
        List<List<Integer>> list = BinaryTree.levelOrder(root);
        System.out.println(list);
    }

    @Test
    @DisplayName("二叉树的最大深度-递归（自底向上）")
    public void maxDepthTest() {
        int i = BinaryTree.maxDepth(root);
        Assertions.assertEquals(i, 3);
    }

    @Test
    @DisplayName("二叉树的最大深度-迭代（自顶向下）")
    public void maxDepth2Test() {
        int i = BinaryTree.maxDepth2(root);
        Assertions.assertEquals(i, 3);
    }

    @Test
    @DisplayName("对称二叉树-递归")
    public void isSymmetricTest() {
        TreeNode treeNode = createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 0);
        boolean result = BinaryTree.isSymmetric(treeNode);
        Assertions.assertTrue(result);

        treeNode = createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3}, 0);
        result = BinaryTree.isSymmetric(treeNode);
        Assertions.assertTrue(!result);
    }

    @Test
    @DisplayName("对称二叉树-迭代")
    public void isSymmetric2Test() {
        TreeNode treeNode = createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3}, 0);
        boolean result = BinaryTree.isSymmetric2(treeNode);
        Assertions.assertTrue(result);

        treeNode = createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3}, 0);
        result = BinaryTree.isSymmetric2(treeNode);
        Assertions.assertTrue(!result);
    }

    private TreeNode hasPathSumNode() {
        TreeNode root = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n44 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

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
        TreeNode root = hasPathSumNode();

        boolean result = BinaryTree.hasPathSum(root, 22);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("路径总和-迭代")
    public void hasPathSum2Test() {
        TreeNode root = hasPathSumNode();

        boolean result = BinaryTree.hasPathSum2(root, 22);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("从前序与中序遍历序列构造二叉树-递归")
    public void buildTreeTest() {
        TreeNode treeNode = BinaryTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    @Test
    @DisplayName("从中序与后序遍历序列构造二叉树-递归")
    public void buildTree2Test() {
        TreeNode treeNode = BinaryTree.buildTree2(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }

    @Test
    @DisplayName("填充每个节点的下一个右侧节点指针-递归")
    public void connectTest() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;

        Node node = BinaryTree.connect(n1);
        System.out.println(node);
    }

    @Test
    @DisplayName("填充每个节点的下一个右侧节点指针-递归")
    public void connect2Test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n4.left = n7;
        n6.right = n8;
        n3.right = n6;
        n2.left = n4;
        n2.right = n5;
        n1.left = n2;
        n1.right = n3;

        Node node = BinaryTree.connect2(n1);
        System.out.println(node);
    }

    @Test
    @DisplayName("二叉树的最近公共祖先")
    public void lowestCommonAncestorTest(){
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        n2.left = n7;
        n2.right = n4;
        n5.left = n6;
        n5.right = n2;
        n1.left = n0;
        n1.right = n8;
        n3.left = n5;
        n3.right = n1;

        TreeNode treeNode = BinaryTree.lowestCommonAncestor(n3, n6, n4);
        Assertions.assertEquals(treeNode.val, n5.val);

    }

    @Test
    @DisplayName("二叉树的序列化")
    public void serializeTest() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n3.left = n4;
        n3.right = n5;
        n1.left = n2;
        n1.right = n3;

        String s = BinaryTree.Codec.serialize(n1);
        System.out.println(s);
    }

    @Test
    @DisplayName("二叉树的反序列化")
    public void deserializeTest() {
        TreeNode node = BinaryTree.Codec.deserialize("1,2,3,null,null,4,5");
//        TreeNode node = TwoForkTree.Codec.deserialize("1,null,1,null,1,null,1");
        System.out.println(node);
    }
}
