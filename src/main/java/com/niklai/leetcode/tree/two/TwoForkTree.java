package com.niklai.leetcode.tree.two;

import java.util.*;

public class TwoForkTree {

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

    //    给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
    //    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    //
    //    初始状态下，所有 next 指针都被设置为 NULL。
    //    输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
    //
    //    输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
    //
    //    解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
    //    提示：
    //
    //    你只能使用常量级额外空间。
    //    使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }

            connect(root.left);
            connect(root.right);
        }

        return root;
    }

    //    给定一个二叉树,填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
    //    初始状态下，所有 next 指针都被设置为 NULL。
    //
    //    输入：root = [1,2,3,4,5,null,7]
    //    输出：[1,#,2,3,#,4,5,7,#]
    //    解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
    public static Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                Node node = root.next;
                while (node != null) {
                    if (node.left != null) {
                        root.left.next = node.left;
                        break;
                    }

                    if (node.right != null) {
                        root.left.next = node.right;
                        break;
                    }

                    node = node.next;
                }
            }
        }

        if (root.right != null) {
            Node node = root.next;
            while (node != null) {
                if (node.left != null) {
                    root.right.next = node.left;
                    break;
                }

                if (node.right != null) {
                    root.right.next = node.right;
                    break;
                }

                node = node.next;
            }
        }

        connect2(root.right);
        connect2(root.left);
        return root;
    }

    //    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //
    //    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    //    示例 1:
    //
    //    输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    //    输出: 3
    //    解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
    //
    //    示例 2:
    //
    //    输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    //    输出: 5
    //    解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
    //
    //
    //
    //    说明:
    //
    //    所有节点的值都是唯一的。
    //    p、q 为不同节点且均存在于给定的二叉树中。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果一个节点的左节点和右节点分别存在对应节点，则此节点为公共祖先节点
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    //    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    //
    //    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    //
    //    示例:
    //
    //    你可以将以下二叉树：
    //
    //            1
    //           / \
    //          2   3
    //             / \
    //            4   5
    //
    //    序列化为 "[1,2,3,null,null,4,5]"
    //
    //    提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
    //
    //    说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
    public static class Codec {

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }

            List<String> list = new ArrayList<>();
            LinkedList<TreeNode> lk = new LinkedList<>();
            lk.offer(root);
            int i = lk.size();
            while (true) {
                boolean end = true;
                while (i > 0) {
                    TreeNode node = lk.pop();
                    i--;
                    if (node == null) {
                        list.add("null");
                        lk.offer(null);
                        lk.offer(null);
                    } else {
                        list.add(String.valueOf(node.val));
                        lk.offer(node.left);
                        lk.offer(node.right);
                        end = end && (node.left == null) && (node.right == null);
                    }
                }

                if (end) {
                    break;
                } else {
                    i = lk.size();
                }
            }

            return String.join(",", list);
        }

        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }

            String[] arr = data.split(",");
            if (arr.length == 0) {
                return null;
            }

            TreeNode root = createNodeItem(arr, 0);
            return root;
        }

        private static TreeNode createNodeItem(String[] arr, int idx) {
            TreeNode node = null;
            if (idx < arr.length) {
                String num = arr[idx];
                if (num.equals("null")) {
                    return null;
                }

                node = new TreeNode(Integer.valueOf(num));
                node.left = createNodeItem(arr, 2 * idx + 1);
                node.right = createNodeItem(arr, 2 * idx + 2);
            }

            return node;
        }
    }
}
