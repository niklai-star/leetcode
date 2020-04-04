package com.niklai.leetcode.tree.n;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NForkTree {

    //    给定一个 N 叉树，返回其节点值的前序遍历。
    //
    //    例如，给定一个 3叉树 :
    //
    //
    //
    //
    //
    //    返回其前序遍历: [1,3,5,6,2,4]。
    //
    //
    //
    //    说明: 递归法很简单，你可以使用迭代法完成此题吗?
    public static List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                list.addAll(preorder(node));
            }
        }

        return list;
    }

    //    给定一个 N 叉树，返回其节点值的后序遍历。
    //
    //    例如，给定一个 3叉树 :
    //
    //
    //
    //
    //
    //    返回其后序遍历: [5,6,3,2,4,1].
    //
    //
    //
    //    说明: 递归法很简单，你可以使用迭代法完成此题吗?
    public static List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        if (root.children != null) {
            for (Node node : root.children) {
                list.addAll(postorder(node));
            }
        }

        list.add(root.val);
        return list;
    }

    //    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    //
    //    例如，给定一个 3叉树 :
    //
    //
    //
    //
    //
    //    返回其层序遍历:
    //
    //            [
    //              [1],
    //              [3,2,4],
    //              [5,6]
    //            ]
    //
    //
    //
    //    说明:
    //
    //    树的深度不会超过 1000。
    //    树的节点总数不会超过 5000。
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<Node> lk = new LinkedList<>();
        lk.offer(root);
        int count = 1;
        while (!lk.isEmpty()) {
            int loopCount = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Node node = lk.poll();
                list.add(node.val);
                if (node.children != null) {
                    for (Node item : node.children) {
                        lk.offer(item);
                    }

                    loopCount += node.children.size();
                }
            }
            result.add(list);
            count = loopCount;
        }

        return result;
    }

    //    给定一个 N 叉树，找到其最大深度。
    //
    //    最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
    //
    //    例如，给定一个 3叉树 :
    //
    //
    //
    //
    //
    //    我们应返回其最大深度，3。
    //
    //    说明:
    //
    //    树的深度不会超过 1000。
    //    树的节点总不会超过 5000。
    public static int maxDepth(Node root) {
        if(root == null){
            return 0;
        }

        int depth = 1;
        if(root.children == null){
            return depth;
        }

        for(Node node : root.children){
            depth = Math.max(maxDepth(node) + 1, depth);
        }

        return depth;
    }
}
