package com.niklai.leetcode.tree.n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NForkTreeTest {

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

        List<Integer> result = NForkTree.preorder(root);
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

        List<Integer> result = NForkTree.postorder(root);
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

        List<List<Integer>> result = NForkTree.levelOrder(root);
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

        int i = NForkTree.maxDepth(root);
        Assertions.assertEquals(3, i);
    }
}
