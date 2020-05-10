package com.niklai.leetcode.search;

import com.niklai.leetcode.tree.binary.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTest {

    @Test
    @DisplayName("二分查找")
    public void searchTest() {
        int result = BinarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        Assertions.assertEquals(4, result);

        result = BinarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        Assertions.assertEquals(-1, result);

        result = BinarySearch.search(new int[]{5}, -5);
        Assertions.assertEquals(-1, result);

        result = BinarySearch.search(new int[]{2, 5}, 0);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("x 的平方根")
    public void mySqrtTest() {
        int result = BinarySearch.mySqrt(4);
        Assertions.assertEquals(2, result);

        result = BinarySearch.mySqrt(8);
        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("搜索旋转排序数组")
    public void rotateSearchTest() {
        Assertions.assertEquals(4, BinarySearch.rotateSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assertions.assertEquals(-1, BinarySearch.rotateSearch(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    @DisplayName("第一个错误的版本")
    public void firstBadVersionTest() {
        BinarySearch.Solution s = new BinarySearch.Solution();
        Assertions.assertEquals(4, s.firstBadVersion(5));
    }

    @Test
    @DisplayName("寻找峰值")
    public void findPeakElementTest() {
        int result = BinarySearch.findPeakElement(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(2, result);

        result = BinarySearch.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        Assertions.assertTrue(Arrays.asList(1, 5).contains(result));

        result = BinarySearch.findPeakElement(new int[]{1});
        Assertions.assertEquals(0, result);

        result = BinarySearch.findPeakElement(new int[]{2, 1});
        Assertions.assertEquals(0, result);

        result = BinarySearch.findPeakElement(new int[]{1, 2});
        Assertions.assertEquals(1, result);

        result = BinarySearch.findPeakElement(new int[]{1, 2, 3});
        Assertions.assertEquals(2, result);

        result = BinarySearch.findPeakElement(new int[]{1, 3, 1});
        Assertions.assertEquals(1, result);

        result = BinarySearch.findPeakElement(new int[]{3, 2, 1});
        Assertions.assertEquals(0, result);

        result = BinarySearch.findPeakElement(new int[]{1, 2, 3, 4});
        Assertions.assertEquals(3, result);

        result = BinarySearch.findPeakElement(new int[]{1, 2, 3, 4, 5});
        Assertions.assertEquals(4, result);
    }

    @Test
    @DisplayName("寻找旋转排序数组中的最小值")
    public void findMinTest() {
        int result = BinarySearch.findMin(new int[]{3, 4, 5, 1, 2});
        Assertions.assertEquals(1, result);

        result = BinarySearch.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("在排序数组中查找元素的第一个和最后一个位置")
    public void searchRangeTest() {
        int[] result = BinarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assertions.assertTrue(result[0] == 3 && result[1] == 4);

        result = BinarySearch.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assertions.assertTrue(result[0] == -1 && result[1] == -1);

        result = BinarySearch.searchRange(new int[]{6, 6, 6, 6, 6, 6}, 6);
        Assertions.assertTrue(result[0] == 0 && result[1] == 5);

        result = BinarySearch.searchRange(new int[]{6}, 6);
        Assertions.assertTrue(result[0] == 0 && result[1] == 0);
    }

    @Test
    @DisplayName("找到 K 个最接近的元素")
    public void findClosestElementsTest() {
        List<Integer> result = BinarySearch.findClosestElements(new int[]{1, 2, 5, 6, 7}, 3, 3);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 5, 6, 7}, 3, 4);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 5, 6, 7}, 3, 0);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 5, 6, 7}, 3, 8);

        result = BinarySearch.findClosestElements(new int[]{1, 2}, 3, 0);

        result = BinarySearch.findClosestElements(new int[]{1, 2}, 3, 3);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 3);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 3, 3, 4, 5}, 3, 3);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 3, 3, 3, 4, 5}, 3, 3);

        result = BinarySearch.findClosestElements(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3, 3);

        result = BinarySearch.findClosestElements(new int[]{1}, 1, 1);

        result = BinarySearch.findClosestElements(new int[]{1, 2}, 1, 1);
    }

    @Test
    @DisplayName("最接近的二叉搜索树值")
    public void closestValueTest() {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        root.left = n2;
        root.right = n5;

        int result = BinarySearch.closestValue(root, 3.714286);
        Assertions.assertEquals(4, result);
    }

    @Test
    @DisplayName("搜索长度未知的有序数组")
    public void searchTest2() {
        int result = BinarySearch.search(new BinarySearch.ArrayReader(new int[]{-1, 0, 3, 5, 9, 12}), 9);
        Assertions.assertEquals(4, result);

        result = BinarySearch.search(new BinarySearch.ArrayReader(new int[]{-1, 0, 3, 5, 9}), 2);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("Pow(x, n)")
    public void myPowTest() {
        double result = BinarySearch.myPow(2.00000, 10);
        Assertions.assertEquals(1024.00000, result, 0.00000);

//        result = TwoPoints.myPow(2.10000, 3);
//        Assertions.assertEquals(9.26100, result, 0.00000);

        result = BinarySearch.myPow(2.00000, -2);
        Assertions.assertEquals(0.25, result, 0.00);
    }

    @Test
    @DisplayName("有效的完全平方数")
    public void isPerfectSquareTest() {
        Assertions.assertTrue(BinarySearch.isPerfectSquare(808201));
        Assertions.assertTrue(BinarySearch.isPerfectSquare(16));
        Assertions.assertTrue(!BinarySearch.isPerfectSquare(14));
    }

    @Test
    @DisplayName("寻找比目标字母大的最小字母")
    public void nextGreatestLetterTest() {
        char[] ch = {'c', 'f', 'j'};
        char result = BinarySearch.nextGreatestLetter(ch, 'a');
        Assertions.assertEquals('c', result);

        result = BinarySearch.nextGreatestLetter(ch, 'c');
        Assertions.assertEquals('f', result);

        result = BinarySearch.nextGreatestLetter(ch, 'd');
        Assertions.assertEquals('f', result);

        result = BinarySearch.nextGreatestLetter(ch, 'g');
        Assertions.assertEquals('j', result);

        result = BinarySearch.nextGreatestLetter(ch, 'j');
        Assertions.assertEquals('c', result);

        result = BinarySearch.nextGreatestLetter(ch, 'k');
        Assertions.assertEquals('c', result);
    }

    @Test
    @DisplayName("寻找旋转排序数组中的最小值(数组中有重复数字)")
    public void findMinRepeatTest() {
        int result = BinarySearch.findMinRepeat(new int[]{1, 3, 5});
        Assertions.assertEquals(1, result);

        result = BinarySearch.findMinRepeat(new int[]{2, 2, 2, 0, 0, 1, 2});
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("两数之和 II - 输入有序数组")
    public void twoSumTest() {
        int[] result = BinarySearch.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);

        result = BinarySearch.twoSum(new int[]{1, 3, 4, 5, 7, 9}, 13);
        Assertions.assertEquals(3, result[0]);
        Assertions.assertEquals(6, result[1]);


        result = BinarySearch.twoSum(new int[]{-1, 0}, -1);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);

        result = BinarySearch.twoSum(new int[]{-2, -1, 0}, -1);
        Assertions.assertEquals(2, result[0]);
        Assertions.assertEquals(3, result[1]);
    }
}
