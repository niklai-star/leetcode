package com.niklai.leetcode.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class QueuesTest {

    @Test
    @DisplayName("设计循环队列")
    public void MyCircularQueueTest() {
        Queues.MyCircularQueue queue = new Queues.MyCircularQueue(3);
        Assertions.assertTrue(queue.enQueue(1));
        Assertions.assertTrue(queue.enQueue(2));
        Assertions.assertTrue(queue.enQueue(3));
        Assertions.assertTrue(!queue.enQueue(4));
        Assertions.assertTrue(queue.deQueue());
        Assertions.assertTrue(queue.enQueue(4));
        Assertions.assertTrue(queue.deQueue());
        Assertions.assertTrue(queue.deQueue());
        Assertions.assertTrue(queue.deQueue());
    }

    @Test
    @DisplayName("数据流中的移动平均值")
    public void MovingAverageTest() {
        Queues.MovingAverage movingAverage = new Queues.MovingAverage(3);
        Assertions.assertEquals((double) 1 / 1, movingAverage.next(1));
        Assertions.assertEquals((double) (1 + 10) / 2, movingAverage.next(10));
        Assertions.assertEquals((double) (1 + 10 + 3) / 3, movingAverage.next(3));
        Assertions.assertEquals((double) (10 + 3 + 5) / 3, movingAverage.next(5));
    }

    @Test
    @DisplayName("岛屿数量-队列（广度优先）")
    public void numIslandsTest() {
        int result = Queues.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        Assertions.assertEquals(1, result);

        result = Queues.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
        Assertions.assertEquals(3, result);

        result = Queues.numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("岛屿数量-栈（深度优先）")
    public void numIslands2Test() {
        int result = Queues.numIslands2(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        Assertions.assertEquals(1, result);

        result = Queues.numIslands2(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}});
        Assertions.assertEquals(3, result);

        result = Queues.numIslands2(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("完全平方数")
    public void numSquaresTest() {
        int result = Queues.numSquares(12);
        Assertions.assertEquals(3, result);

        result = Queues.numSquares(13);
        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("墙与门")
    public void wallsAndGatesTest() {
        int[][] nums = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        Queues.wallsAndGates(nums);
        System.out.println(nums);
    }

    @Test
    @DisplayName("图像渲染")
    public void floodFillTest() {
        int[][] flood = Queues.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
    }

    @Test
    @DisplayName("01 矩阵")
    public void updateMatrixTest() {
        int[][] matrix = Queues.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        matrix = Queues.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        matrix = Queues.updateMatrix(new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        });
    }

    @Test
    @DisplayName("钥匙和房间")
    public void canVisitAllRoomsTest() {
        Assertions.assertTrue(
                Queues.canVisitAllRooms(Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(2),
                        Arrays.asList(3),
                        Arrays.asList()
                )));

        Assertions.assertTrue(
                !Queues.canVisitAllRooms(Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(3, 0, 1),
                        Arrays.asList(2),
                        Arrays.asList(0)
                )));
    }

    @Test
    @DisplayName("打开转盘锁")
    public void openLockTest() {
        int result = Queues.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
        Assertions.assertEquals(6, result);

        result = Queues.openLock(new String[]{"8888"}, "0009");
        Assertions.assertEquals(1, result);

        result = Queues.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
        Assertions.assertEquals(-1, result);

        result = Queues.openLock(new String[]{"0000"}, "8888");
        Assertions.assertEquals(-1, result);
    }
}
