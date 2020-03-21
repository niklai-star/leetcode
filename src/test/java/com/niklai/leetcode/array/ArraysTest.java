package com.niklai.leetcode.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArraysTest {

    @Test
    @DisplayName("寻找数组的中心索引")
    public void pivotIndexTest() {
        int[] nums = {-1, -1, -1, 0, 1, 1};
        System.out.println(Arrays.pivotIndex(nums));
    }

    @Test
    @DisplayName("至少是其他数字两倍的最大数")
    public void dominantIndexTest() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.dominantIndex(nums));
    }

    @Test
    @DisplayName("加一")
    public void plusOneTest() {
        int[] nums = {4, 3, 2, 1};
        System.out.println(Arrays.plusOne(nums));
    }

    @Test
    @DisplayName("对角线遍历")
    public void findDiagonalOrderTest() {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.findDiagonalOrder(nums));
    }

    //    @Test
//    @DisplayName("对角线遍历")
    public void spiralOrderTest() {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.spiralOrder(nums));
    }

    @Test
    @DisplayName("从排序数组中删除重复项")
    public void removeDuplicatesTest() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.removeDuplicates(nums));
    }

    @Test
    @DisplayName("旋转数组")
    public void rotateTest() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.rotate(nums, 3);
        System.out.println(java.util.Arrays.toString(nums));
    }

    @Test
    @DisplayName("存在重复")
    public void containsDuplicateTest() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.containsDuplicate(nums));
    }
}
