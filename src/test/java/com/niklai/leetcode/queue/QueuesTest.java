package com.niklai.leetcode.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
