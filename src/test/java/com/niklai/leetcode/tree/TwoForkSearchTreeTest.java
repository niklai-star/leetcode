package com.niklai.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwoForkSearchTreeTest {

    @Test
    @DisplayName("验证二叉搜索树1")
    public void isValidBSTTest1() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;

        boolean result = TwoForkSearchTree.isValidBST(n2);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("验证二叉搜索树2")
    public void isValidBSTTest2() {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        n4.left = n3;
        n4.right = n6;
        n5.left = n1;
        n5.right = n4;

        boolean result = TwoForkSearchTree.isValidBST(n5);
        Assertions.assertTrue(!result);
    }

    @Test
    @DisplayName("二叉搜索树迭代器")
    public void bstIteratorTest(){
        TreeNode n7 = new TreeNode(7);
        TreeNode n3 = new TreeNode(3);
        TreeNode n15 = new TreeNode(15);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);

        n15.left = n9;
        n15.right = n20;
        n7.left = n3;
        n7.right = n15;

        TwoForkSearchTree.BSTIterator iterator = new TwoForkSearchTree.BSTIterator(n7);
        System.out.println(iterator.next());    // 返回 3
        System.out.println(iterator.next());    // 返回 7
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 9
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        System.out.println(iterator.hasNext()); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        System.out.println(iterator.hasNext()); // 返回 false
    }

    @Test
    @DisplayName("Search in a Binary Search Tree")
    public void searchBSTTest(){
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        n4.left = n2;
        n4.right = n7;

        TreeNode treeNode = TwoForkSearchTree.searchBST(n4, 2);
        Assertions.assertEquals(treeNode.val, n2.val);

        treeNode = TwoForkSearchTree.searchBST(n4, 5);
        Assertions.assertNull(treeNode);
    }

    @Test
    @DisplayName("Insert into a Binary Search Tree")
    public void insertIntoBSTTest(){
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        n4.left = n2;
        n4.right = n7;

        TreeNode treeNode = TwoForkSearchTree.insertIntoBST(n4, 5);
        Assertions.assertEquals(treeNode.val, n4.val);
    }
}
