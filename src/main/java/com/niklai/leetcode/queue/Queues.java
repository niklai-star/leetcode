package com.niklai.leetcode.queue;

import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class Queues {

    //    你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
    //
    //    -1 表示墙或是障碍物
    //    0 表示一扇门
    //    INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
    //
    //    你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
    //
    //    示例：
    //
    //    给定二维网格：
    //
    //    INF  -1  0  INF
    //    INF INF INF  -1
    //    INF  -1 INF  -1
    //      0  -1 INF INF
    //
    //    运行完你的函数后，该网格应该变成：
    //
    //    3  -1   0   1
    //    2   2   1  -1
    //    1  -1   2  -1
    //    0  -1   3   4
    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    wallsAndGatesItem(rooms, i, j, 1, rows, cols);
                }
            }
        }
    }

    private static void wallsAndGatesItem(int[][] rooms, int i, int j, int rounds, int rows, int cols) {
        // 上
        if ((i - 1) >= 0 && rooms[i - 1][j] > 0) {
            if (rooms[i - 1][j] > rounds) {
                rooms[i - 1][j] = rounds;
                wallsAndGatesItem(rooms, i - 1, j, rounds + 1, rows, cols);
            }
        }

        // 下
        if ((i + 1) < rows && rooms[i + 1][j] > 0) {
            if (rooms[i + 1][j] > rounds) {
                rooms[i + 1][j] = rounds;
                wallsAndGatesItem(rooms, i + 1, j, rounds + 1, rows, cols);
            }
        }

        // 左
        if ((j - 1) >= 0 && rooms[i][j - 1] > 0) {
            if (rooms[i][j - 1] > rounds) {
                rooms[i][j - 1] = rounds;
                wallsAndGatesItem(rooms, i, j - 1, rounds + 1, rows, cols);
            }
        }

        // 右
        if ((j + 1) < cols && rooms[i][j + 1] > 0) {
            if (rooms[i][j + 1] > rounds) {
                rooms[i][j + 1] = rounds;
                wallsAndGatesItem(rooms, i, j + 1, rounds + 1, rows, cols);
            }
        }
    }

    //    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
    //
    //    示例 1:
    //
    //    输入:
    //        11110
    //        11010
    //        11000
    //        00000
    //
    //    输出: 1
    //
    //    示例 2:
    //
    //    输入:
    //        11000
    //        11000
    //        00100
    //        00011
    //
    //    输出: 3
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    numIslandsItem(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void numIslandsItem(char[][] grid, int idx_i, int idx_j) {
        LinkedList<String> idxList = new LinkedList<>();
        idxList.offer(idx_i + ":" + idx_j);
        grid[idx_i][idx_j] = '0';

        while (!idxList.isEmpty()) {
            String[] idx = idxList.pop().split(":");
            int i = Integer.valueOf(idx[0]);
            int j = Integer.valueOf(idx[1]);

            // 上
            if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                String index = String.format("%d:%d", i - 1, j);
                idxList.offer(index);
                grid[i - 1][j] = '0';
            }

            // 左
            if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                String index = String.format("%d:%d", i, j - 1);
                idxList.offer(index);
                grid[i][j - 1] = '0';
            }

            // 下
            if (i + 1 < grid.length && grid[i + 1][j] == '1') {
                String index = String.format("%d:%d", i + 1, j);
                idxList.offer(index);
                grid[i + 1][j] = '0';
            }

            // 右
            if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                String index = String.format("%d:%d", i, j + 1);
                idxList.offer(index);
                grid[i][j + 1] = '0';
            }
        }
    }

    public static int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    numIslandsItem2(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void numIslandsItem2(char[][] grid, int idx_i, int idx_j) {
        if (idx_i < 0 || idx_i >= grid.length || idx_j < 0 || idx_j >= grid[0].length) {
            return;
        }

        if (grid[idx_i][idx_j] == '0') {
            return;
        }

        grid[idx_i][idx_j] = '0';

        // 上
        numIslandsItem2(grid, idx_i - 1, idx_j);

        // 左
        numIslandsItem2(grid, idx_i, idx_j - 1);

        // 下
        numIslandsItem2(grid, idx_i + 1, idx_j);

        // 右
        numIslandsItem2(grid, idx_i, idx_j + 1);
    }

    /**
     * @param n
     * @return
     * @see QueuesTest#numSquaresTest()
     */
    //    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    //
    //    示例 1:
    //
    //    输入: n = 12
    //    输出: 3
    //    解释: 12 = 4 + 4 + 4.
    //
    //    示例 2:
    //
    //    输入: n = 13
    //    输出: 2
    //    解释: 13 = 4 + 9.
    public static int numSquares(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        LinkedList<Integer> lk = new LinkedList<>();
        lk.offer(n);
        int count = 0;
        while (!lk.isEmpty()) {
            Integer num = lk.poll();
            int sqrt = (int) Math.sqrt(num);
            if (num != sqrt * sqrt) {
                lk.offer(num - sqrt * sqrt);
            }

            count++;
        }

        return count;
    }

    //    有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
//
//    给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
//
//    为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
//
//    最后返回经过上色渲染后的图像。
//
//    示例 1:
//
//        输入:
//        image = [[1,1,1],[1,1,0],[1,0,1]]
//        sr = 1, sc = 1, newColor = 2
//        输出: [[2,2,2],[2,2,0],[2,0,1]]
//        解析:
//        在图像的正中间，(坐标(sr,sc)=(1,1)),
//        在路径上所有符合条件的像素点的颜色都被更改成2。
//        注意，右下角的像素没有更改为2，
//        因为它不是在上下左右四个方向上与初始点相连的像素点。
//
//    注意:
//
//        image 和 image[0] 的长度在范围 [1, 50] 内。
//        给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
//        image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == sr && j == sc) {
                    LinkedList<String> lk = new LinkedList<>();
                    lk.offer(i + ":" + j);
                    visited[i][j] = true;
                    while (!lk.isEmpty()) {
                        String[] split = lk.poll().split(":");
                        int idx_i = Integer.valueOf(split[0]);
                        int idx_j = Integer.valueOf(split[1]);

                        // 上
                        if (idx_i - 1 >= 0 && !visited[idx_i - 1][idx_j] && image[idx_i - 1][idx_j] == image[idx_i][idx_j]) {
                            lk.offer((idx_i - 1) + ":" + idx_j);
                            visited[idx_i - 1][idx_j] = true;
                        }

                        // 下
                        if (idx_i + 1 < rows && !visited[idx_i + 1][idx_j] && image[idx_i + 1][idx_j] == image[idx_i][idx_j]) {
                            lk.offer((idx_i + 1) + ":" + idx_j);
                            visited[idx_i + 1][idx_j] = true;
                        }

                        // 左
                        if (idx_j - 1 >= 0 && !visited[idx_i][idx_j - 1] && image[idx_i][idx_j - 1] == image[idx_i][idx_j]) {
                            lk.offer(idx_i + ":" + (idx_j - 1));
                            visited[idx_i][idx_j - 1] = true;
                        }

                        // 右
                        if (idx_j + 1 < cols && !visited[idx_i][idx_j + 1] && image[idx_i][idx_j + 1] == image[idx_i][idx_j]) {
                            lk.offer(idx_i + ":" + (idx_j + 1));
                            visited[idx_i][idx_j + 1] = true;
                        }

                        image[idx_i][idx_j] = newColor;
                    }
                }
            }
        }

        return image;
    }


    /**
     * @param matrix
     * @return
     * @see QueuesTest#updateMatrixTest()
     */
    //    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
    //
    //    两个相邻元素间的距离为 1 。
    //
    //    示例 1:
    //    输入:
    //
    //            0 0 0
    //            0 1 0
    //            0 0 0
    //
    //    输出:
    //
    //            0 0 0
    //            0 1 0
    //            0 0 0
    //
    //    示例 2:
    //    输入:
    //
    //            0 0 0
    //            0 1 0
    //            1 1 1
    //
    //    输出:
    //
    //            0 0 0
    //            0 1 0
    //            1 2 1
    //
    //    注意:
    //
    //        给定矩阵的元素个数不超过 10000。
    //        给定矩阵中至少有一个元素是 0。
    //        矩阵中的元素只在四个方向上相邻: 上、下、左、右。
    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        LinkedList<String> lk = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    lk.offer(String.format("%d:%d", i, j));
                    int deep = 1;
                    int size = 1;
                    while (!lk.isEmpty()) {
                        boolean find = false;
                        int count = 0;
                        for (int k = 0; k < size; k++) {
                            String[] split = lk.poll().split(":");
                            int ii = Integer.valueOf(split[0]);
                            int jj = Integer.valueOf(split[1]);

                            // 上
                            if (ii - 1 >= 0) {
                                if (matrix[ii - 1][jj] == 0) {
                                    find = true;
                                    break;
                                } else {
                                    lk.offer(String.format("%d:%d", ii - 1, jj));
                                    count++;
                                }
                            }

                            // 下
                            if (ii + 1 < rows) {
                                if (matrix[ii + 1][jj] == 0) {
                                    find = true;
                                    break;
                                } else {
                                    lk.offer(String.format("%d:%d", ii + 1, jj));
                                    count++;
                                }
                            }

                            // 左
                            if (jj - 1 >= 0) {
                                if (matrix[ii][jj - 1] == 0) {
                                    find = true;
                                    break;
                                } else {
                                    lk.offer(String.format("%d:%d", ii, jj - 1));
                                    count++;
                                }
                            }

                            // 右
                            if (jj + 1 < cols) {
                                if (matrix[ii][jj + 1] == 0) {
                                    find = true;
                                    break;
                                } else {
                                    lk.offer(String.format("%d:%d", ii, jj + 1));
                                    count++;
                                }
                            }
                        }

                        if (find) {
                            break;
                        } else {
                            size = count;
                            deep++;
                        }
                    }

                    matrix[i][j] = deep;
                    lk.clear();
                }
            }
        }

        return matrix;
    }

    /**
     * @param rooms
     * @return
     * @see QueuesTest#canVisitAllRoomsTest()
     */
    //    有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
    //
    //    在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
    //
    //    最初，除 0 号房间外的其余所有房间都被锁住。
    //
    //    你可以自由地在房间之间来回走动。
    //
    //    如果能进入每个房间返回 true，否则返回 false。
    //
    //    示例 1：
    //
    //    输入: [[1],[2],[3],[]]
    //    输出: true
    //    解释:
    //    我们从 0 号房间开始，拿到钥匙 1。
    //    之后我们去 1 号房间，拿到钥匙 2。
    //    然后我们去 2 号房间，拿到钥匙 3。
    //    最后我们去了 3 号房间。
    //    由于我们能够进入每个房间，我们返回 true。
    //
    //    示例 2：
    //
    //    输入：[[1,3],[3,0,1],[2],[0]]
    //    输出：false
    //    解释：我们不能进入 2 号房间。
    //
    //    提示：
    //
    //        1 <= rooms.length <= 1000
    //        0 <= rooms[i].length <= 1000
    //        所有房间中的钥匙数量总计不超过 3000
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> lk = new LinkedList<>();
        List<Integer> room = rooms.get(0);
        visited.add(0);
        for (Integer r : room) {
            lk.offer(r);
        }

        while (!lk.isEmpty()) {
            Integer roomIndex = lk.poll();
            if (!visited.contains(roomIndex)) {
                visited.add(roomIndex);
                room = rooms.get(roomIndex);
                for (Integer r : room) {
                    lk.offer(r);
                }
            }
        }

        return visited.size() == rooms.size();
    }

    //    设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
    //
    //    循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
    //
    //    你的实现应该支持如下操作：
    //
    //    MyCircularQueue(k): 构造器，设置队列长度为 k 。
    //    Front: 从队首获取元素。如果队列为空，返回 -1 。
    //    Rear: 获取队尾元素。如果队列为空，返回 -1 。
    //    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    //    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    //    isEmpty(): 检查循环队列是否为空。
    //    isFull(): 检查循环队列是否已满。
    //
    //
    //
    //    示例：
    //
    //        MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3
    //
    //        circularQueue.enQueue(1);  // 返回 true
    //
    //        circularQueue.enQueue(2);  // 返回 true
    //
    //        circularQueue.enQueue(3);  // 返回 true
    //
    //        circularQueue.enQueue(4);  // 返回 false，队列已满
    //
    //        circularQueue.Rear();  // 返回 3
    //
    //        circularQueue.isFull();  // 返回 true
    //
    //        circularQueue.deQueue();  // 返回 true
    //
    //        circularQueue.enQueue(4);  // 返回 true
    //
    //        circularQueue.Rear();  // 返回 4
    //
    //
    //
    //
    //    提示：
    //
    //        所有的值都在 0 至 1000 的范围内；
    //        操作数将在 1 至 1000 的范围内；
    //        请不要使用内置的队列库。
    public static class MyCircularQueue {
        private int front = -1;
        private int rear = -1;
        private Integer[] arr = null;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            arr = new Integer[k];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (this.isFull()) {
                return false;
            }
            if (rear == arr.length - 1) {
                rear = 0;
            } else {
                ++rear;
            }
            arr[rear] = value;
            if (front == -1) {
                ++front;
            }

            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (this.isEmpty()) {
                return false;
            }
            arr[front] = null;
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                if (front == arr.length - 1) {
                    front = 0;
                } else {
                    ++front;
                }
            }

            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (this.isEmpty()) {
                return -1;
            }

            return arr[front];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (this.isEmpty()) {
                return -1;
            }

            return arr[rear];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (rear - front == arr.length - 1) || (front - rear == 1);
        }
    }

    //    给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
    //
    //    示例:
    //
    //        MovingAverage m = new MovingAverage(3);
    //        m.next(1) = 1
    //        m.next(10) = (1 + 10) / 2
    //        m.next(3) = (1 + 10 + 3) / 3
    //        m.next(5) = (10 + 3 + 5) / 3
    public static class MovingAverage {
        private Integer[] arr;
        private int index;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            arr = new Integer[size];
            index = -1;
        }

        public double next(int val) {
            if (index + 1 == arr.length) {
                index = 0;
            } else {
                index++;
            }

            arr[index] = val;
            int total = 0;
            int num = 0;
            for (Integer item : arr) {
                if (item != null) {
                    total += item;
                    num++;
                }
            }

            return (double) total / num;
        }
    }

    /**
     * @param deadends
     * @param target
     * @return
     * @see QueuesTest#openLockTest()
     */
    //    你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
    //
    //    锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
    //
    //    列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
    //
    //    字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
    //
    //
    //
    //    示例 1:
    //
    //    输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
    //    输出：6
    //    解释：
    //    可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
    //    注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
    //    因为当拨动到 "0102" 时这个锁就会被锁定。
    //
    //    示例 2:
    //
    //    输入: deadends = ["8888"], target = "0009"
    //    输出：1
    //    解释：
    //    把最后一位反向旋转一次即可 "0000" -> "0009"。
    //
    //    示例 3:
    //
    //    输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
    //    输出：-1
    //    解释：
    //    无法旋转到目标数字且不被锁定。
    //
    //    示例 4:
    //
    //    输入: deadends = ["0000"], target = "8888"
    //    输出：-1
    //
    //
    //
    //    提示：
    //
    //    死亡列表 deadends 的长度范围为 [1, 500]。
    //    目标数字 target 不会在 deadends 之中。
    //    每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
    public static int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        if (deads.contains(start)) {
            return -1;
        }

        Set<String> set = new HashSet<>();
        set.add(start);

        LinkedList<String> lk = new LinkedList<>();
        lk.offer(start);
        int loop = 1;
        int deep = 0;
        while (!lk.isEmpty()) {
            int count = 0;
            for (int i = 0; i < loop; i++) {
                String str = lk.poll();
                if (str.equals(target)) {
                    return deep;
                }

                // 1.进
                String next = rotateLock(str, 0, 1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 1.退
                next = rotateLock(str, 0, -1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 2.进
                next = rotateLock(str, 1, 1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 2.退
                next = rotateLock(str, 1, -1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 3.进
                next = rotateLock(str, 2, 1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 3.退
                next = rotateLock(str, 2, -1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 4.进
                next = rotateLock(str, 3, 1);
                count = checkAndOffer(next, count, deads, set, lk);

                // 4.退
                next = rotateLock(str, 3, -1);
                count = checkAndOffer(next, count, deads, set, lk);
            }

            loop = count;
            deep++;
        }

        return -1;
    }

    private static String rotateLock(String num, int idx, int direction) {
        char[] chars = num.toCharArray();
        Integer n = Integer.valueOf(String.valueOf(chars[idx]));
        if (direction == 1) {
            n++;
            if (n == 10) {
                n = 0;
            }
        } else {
            n--;
            if (n == -1) {
                n = 9;
            }
        }

        return num.substring(0, idx) + n + num.substring(idx + 1);
    }

    private static int checkAndOffer(String num, int count, Set<String> deads,
                                     Set<String> set, LinkedList<String> lk) {
        if (!deads.contains(num) && !set.contains(num)) {
            lk.offer(num);
            set.add(num);
            count++;
        }

        return count;
    }
}
