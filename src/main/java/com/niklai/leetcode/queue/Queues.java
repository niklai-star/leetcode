package com.niklai.leetcode.queue;

import java.util.LinkedList;

public class Queues {

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
}
