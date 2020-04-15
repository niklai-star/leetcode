package com.niklai.leetcode.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TwoPointsTest {

    @Test
    @DisplayName("二分查找")
    public void searchTest() {
        int result = TwoPoints.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        Assertions.assertEquals(4, result);

        result = TwoPoints.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        Assertions.assertEquals(-1, result);

        result = TwoPoints.search(new int[]{5}, -5);
        Assertions.assertEquals(-1, result);

        result = TwoPoints.search(new int[]{2, 5}, 0);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("x 的平方根")
    public void mySqrtTest() {
        int result = TwoPoints.mySqrt(4);
        Assertions.assertEquals(2, result);

        result = TwoPoints.mySqrt(8);
        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("搜索旋转排序数组")
    public void rotateSearchTest() {
        Assertions.assertEquals(4, TwoPoints.rotateSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assertions.assertEquals(-1, TwoPoints.rotateSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    @DisplayName("第一个错误的版本")
    public void firstBadVersionTest() {
        TwoPoints.Solution s = new TwoPoints.Solution();
        Assertions.assertEquals(4, s.firstBadVersion(5));
    }
}
