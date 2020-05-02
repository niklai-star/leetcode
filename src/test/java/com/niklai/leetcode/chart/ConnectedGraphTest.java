package com.niklai.leetcode.chart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConnectedGraphTest {

    @Test
    @DisplayName("克隆图")
    public void cloneGraphTest() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n3);
        n2.neighbors.add(n1);
        n3.neighbors.add(n4);
        n3.neighbors.add(n2);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        Node result = ConnectedGraph.cloneGraph(n1);
    }
}
