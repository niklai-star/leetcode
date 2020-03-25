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

    private TwoForkTree.Node createNode(Integer[] nums, int idx) {
        TwoForkTree.Node n = null;
        if (idx < nums.length) {
            Integer num = nums[idx];
            if (num == null) {
                return null;
            }

            n = new TwoForkTree.Node(num);
            n.left = createNode(nums, 2 * idx + 1);
            n.right = createNode(nums, 2 * idx + 2);
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

    @Test
    @DisplayName("填充每个节点的下一个右侧节点指针-递归")
    public void connectTest() {
        TwoForkTree.Node n1 = new TwoForkTree.Node(1);
        TwoForkTree.Node n2 = new TwoForkTree.Node(2);
        TwoForkTree.Node n3 = new TwoForkTree.Node(3);
        TwoForkTree.Node n4 = new TwoForkTree.Node(4);
        TwoForkTree.Node n5 = new TwoForkTree.Node(5);
        TwoForkTree.Node n6 = new TwoForkTree.Node(6);
        TwoForkTree.Node n7 = new TwoForkTree.Node(7);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;

        TwoForkTree.Node node = TwoForkTree.connect(n1);
        System.out.println(node);
    }

    @Test
    @DisplayName("填充每个节点的下一个右侧节点指针-递归")
    public void connect2Test() {
        TwoForkTree.Node n1 = new TwoForkTree.Node(1);
        TwoForkTree.Node n2 = new TwoForkTree.Node(2);
        TwoForkTree.Node n3 = new TwoForkTree.Node(3);
        TwoForkTree.Node n4 = new TwoForkTree.Node(4);
        TwoForkTree.Node n5 = new TwoForkTree.Node(5);
        TwoForkTree.Node n6 = new TwoForkTree.Node(6);
        TwoForkTree.Node n7 = new TwoForkTree.Node(7);
        TwoForkTree.Node n8 = new TwoForkTree.Node(8);

        n4.left = n7;
        n6.right = n8;
        n3.right = n6;
        n2.left = n4;
        n2.right = n5;
        n1.left = n2;
        n1.right = n3;

        TwoForkTree.Node node = TwoForkTree.connect2(n1);
        System.out.println(node);
    }

    @Test
    @DisplayName("二叉树的最近公共祖先")
    public void lowestCommonAncestorTest(){
        TwoForkTree.TreeNode n3 = new TwoForkTree.TreeNode(3);
        TwoForkTree.TreeNode n5 = new TwoForkTree.TreeNode(5);
        TwoForkTree.TreeNode n1 = new TwoForkTree.TreeNode(1);
        TwoForkTree.TreeNode n6 = new TwoForkTree.TreeNode(6);
        TwoForkTree.TreeNode n2 = new TwoForkTree.TreeNode(2);
        TwoForkTree.TreeNode n0 = new TwoForkTree.TreeNode(0);
        TwoForkTree.TreeNode n8 = new TwoForkTree.TreeNode(8);
        TwoForkTree.TreeNode n7 = new TwoForkTree.TreeNode(7);
        TwoForkTree.TreeNode n4 = new TwoForkTree.TreeNode(4);

        n2.left = n7;
        n2.right = n4;
        n5.left = n6;
        n5.right = n2;
        n1.left = n0;
        n1.right = n8;
        n3.left = n5;
        n3.right = n1;

        TwoForkTree.TreeNode treeNode = TwoForkTree.lowestCommonAncestor(n3, n6, n4);
        Assertions.assertEquals(treeNode.val, n5.val);

    }

    @Test
    @DisplayName("二叉树的序列化")
    public void serializeTest() {
        TwoForkTree.TreeNode n1 = new TwoForkTree.TreeNode(1);
        TwoForkTree.TreeNode n2 = new TwoForkTree.TreeNode(2);
        TwoForkTree.TreeNode n3 = new TwoForkTree.TreeNode(3);
        TwoForkTree.TreeNode n4 = new TwoForkTree.TreeNode(4);
        TwoForkTree.TreeNode n5 = new TwoForkTree.TreeNode(5);

        n3.left = n4;
        n3.right = n5;
        n1.left = n2;
        n1.right = n3;

        String s = TwoForkTree.Codec.serialize(n1);
        System.out.println(s);
    }

    @Test
    @DisplayName("二叉树的反序列化")
    public void deserializeTest() {
        TwoForkTree.TreeNode node = TwoForkTree.Codec.deserialize("1,2,3,null,null,4,5");
//        TwoForkTree.TreeNode node = TwoForkTree.Codec.deserialize("1,null,1,null,1,null,1");
        System.out.println(node);
    }
}
