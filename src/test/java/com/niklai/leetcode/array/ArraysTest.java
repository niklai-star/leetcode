package com.niklai.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.DoubleStream;

public class ArraysTest {

    @Test
    @DisplayName("寻找数组的中心索引")
    public void pivotIndexTest() {
        int result = Arrays.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        Assertions.assertEquals(3, result);

        result = Arrays.pivotIndex(new int[]{1, 2, 3});
        Assertions.assertEquals(-1, result);
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

    @Test
    @DisplayName("螺旋矩阵")
    public void spiralOrderTest() {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.spiralOrder(nums));
    }

    @Test
    @DisplayName("杨辉三角")
    public void generateTest() {
        List<List<Integer>> result = Arrays.generate(5);
        System.out.println(result);
    }

    @Test
    @DisplayName("二进制求和")
    public void addBinaryTest() {
        String result = Arrays.addBinary("11", "1");
        Assertions.assertEquals("100", result);

        result = Arrays.addBinary("1010", "1011");
        Assertions.assertEquals("10101", result);
    }

    @Test
    @DisplayName("实现 strStr()")
    public void strStrTest() {
        int result = Arrays.strStr("hello", "ll");
        Assertions.assertEquals(2, result);

        result = Arrays.strStr("aaaaa", "bba");
        Assertions.assertEquals(-1, result);

        result = Arrays.strStr("baaaa", "aa");
        Assertions.assertEquals(1, result);

        result = Arrays.strStr("aabbaa", "aa");
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("最长公共前缀")
    public void longestCommonPrefixTest() {
        String result = Arrays.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assertions.assertEquals("fl", result);

        result = Arrays.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        Assertions.assertEquals("", result);

        result = Arrays.longestCommonPrefix(new String[]{"dogdog", "dog", "dogdogdog"});
        Assertions.assertEquals("dog", result);
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
