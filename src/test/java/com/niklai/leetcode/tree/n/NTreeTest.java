package com.niklai.leetcode.tree.n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NTreeTest {

    @Test
    @DisplayName("N-ary Tree Preorder Traversal")
    public void preorderTest() {
        Node root = new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(new Node(5));
        n3.children.add(new Node(6));
        root.children.add(n3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        List<Integer> result = NTree.preorder(root);
        System.out.println(result);
    }

    @Test
    @DisplayName("N-ary Tree Postorder Traversal")
    public void postorderTest() {
        Node root = new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(new Node(5));
        n3.children.add(new Node(6));
        root.children.add(n3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        List<Integer> result = NTree.postorder(root);
        System.out.println(result);
    }

    @Test
    @DisplayName("N叉树的层序遍历")
    public void levelOrderTest() {
        Node root = new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(new Node(5));
        n3.children.add(new Node(6));
        root.children.add(n3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        List<List<Integer>> result = NTree.levelOrder(root);
        System.out.println(result);
    }

    @Test
    @DisplayName("Maximum Depth of N-ary Tree")
    public void maxDepthTest() {
        Node root = new Node(1, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        n3.children.add(new Node(5));
        n3.children.add(new Node(6));
        root.children.add(n3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        int i = NTree.maxDepth(root);
        Assertions.assertEquals(3, i);
    }

    @Test
    public void getAllLeafNodePathTest() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.children.add(n2);
        n1.children.add(n3);
        n3.children.add(n4);
        n3.children.add(n5);
        n5.children.add(n6);

        List<String> result = NTree.getAllLeafNodePath(n1);
        System.out.println(result);
    }
}
